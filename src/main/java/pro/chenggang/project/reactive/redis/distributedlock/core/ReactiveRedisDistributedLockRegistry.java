/*
 * Copyright 2014-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pro.chenggang.project.reactive.redis.distributedlock.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.retry.Repeat;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * reactive redis distributed lock registry
 * @author evans
 * @date 2021/03/14
 */
@Slf4j
public final class ReactiveRedisDistributedLockRegistry implements InitializingBean, DisposableBean {

	private static final Duration DEFAULT_EXPIRE_AFTER = Duration.ofSeconds(60);

	private static final Duration DEFAULT_EXPIRE_EVICT_IDLE = Duration.ofMinutes(30);

	private static final String OBTAIN_LOCK_SCRIPT = "local lockSet = redis.call('SETNX', KEYS[1], ARGV[1])\n" +
			"if lockSet == 1 then\n" +
			"  redis.call('PEXPIRE', KEYS[1], ARGV[2])\n" +
			"  return true\n" +
			"else\n" +
			"  return false\n" +
			"end";


	private final Map<String, ReactiveRedisDistributedLock> locks = new ConcurrentHashMap<>();

	private final String registryKey;

	private final ReactiveStringRedisTemplate reactiveStringRedisTemplate;

	private final RedisScript<Boolean> obtainLockScript;

	private final long expireAfter;

	private final Duration expireEvictIdle;

	private final Duration expireDuration;

	private volatile boolean unlinkAvailable = true;

	private Scheduler scheduler = Schedulers.newSingle("redis-lock-evict",true);

	/**
	 * Constructs a lock registry with the default (60 second) lock expiration.
	 * @param reactiveRedisConnectionFactory The connection factory.
	 * @param registryKey The key prefix for locks.
	 */
	public ReactiveRedisDistributedLockRegistry(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, String registryKey) {
		this(reactiveRedisConnectionFactory, registryKey, DEFAULT_EXPIRE_AFTER,DEFAULT_EXPIRE_EVICT_IDLE);
	}

	/**
	 * Constructs a lock registry with the default (60 second) lock expiration.
	 * @param reactiveRedisConnectionFactory The connection factory.
	 * @param registryKey The key prefix for locks.
	 * @param expireEvictIdle The local lock cache evict
	 */
	public ReactiveRedisDistributedLockRegistry(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, String registryKey, Duration expireEvictIdle) {
		this(reactiveRedisConnectionFactory, registryKey, DEFAULT_EXPIRE_AFTER,expireEvictIdle);
	}

	/**
	 * Constructs a lock registry with the supplied lock expiration.
	 * @param reactiveRedisConnectionFactory The connection factory.
	 * @param registryKey The key prefix for locks.
	 * @param expireAfter The expiration in milliseconds.
	 */
	public ReactiveRedisDistributedLockRegistry(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, String registryKey, Duration expireAfter, Duration expireEvictIdle) {
		Assert.notNull(reactiveRedisConnectionFactory, "'reactiveRedisConnectionFactory' cannot be null");
		Assert.notNull(registryKey, "'registryKey' cannot be null");
		this.reactiveStringRedisTemplate = new ReactiveStringRedisTemplate(reactiveRedisConnectionFactory);
		this.obtainLockScript = new DefaultRedisScript<>(OBTAIN_LOCK_SCRIPT, Boolean.class);
		this.registryKey = registryKey;
		this.expireAfter = expireAfter.toMillis();
		this.expireDuration = expireAfter;
		this.expireEvictIdle = expireEvictIdle;
	}

	public ReactiveDistributedLock obtain(String lockKey) {
		return this.locks.computeIfAbsent(lockKey, ReactiveRedisDistributedLock::new);
	}

	@Override
	public void destroy() {
		log.debug("Shutdown Auto Remove Unused Lock Execution");
		this.scheduler.dispose();
	}

	@Override
	public void afterPropertiesSet() {
		log.debug("Initialize Auto Remove Unused Lock Execution");
		Flux.interval(expireEvictIdle, scheduler)
				.flatMap(value -> {
					long now = System.currentTimeMillis();
					log.trace("Auto Remove Unused Lock ,Evict Triggered");
					return Flux.fromIterable(this.locks.entrySet())
							.filter(entry -> now - entry.getValue().getLockedAt() > expireAfter)
							.flatMap(entry -> entry.getValue()
									.isAcquiredInThisProcess()
									.filter(inProcess -> !inProcess)
									.doOnNext(inProcess -> {
										this.locks.remove(entry.getKey());
										log.debug("Auto Remove Unused Lock,Lock Info:{}", entry);
									})
									.onErrorResume(throwable -> {
										log.error("Auto Remove Unused Locks Occur Exception,Lock Info: " + entry, throwable);
										return Mono.empty();
									})
							);
				})
				.subscribe();
	}

	/**
	 * Implement of ReactiveDistributedLock
	 */
	private final class ReactiveRedisDistributedLock implements ReactiveDistributedLock {

		private final String lockId = UUID.randomUUID().toString();
		private final String lockKey;
		private volatile long lockedAt;

		private ReactiveRedisDistributedLock(String path) {
			this.lockKey = constructLockKey(path);
		}

		private String constructLockKey(String path) {
			return ReactiveRedisDistributedLockRegistry.this.registryKey + ':' + path;
		}

		long getLockedAt() {
			return this.lockedAt;
		}

		@Override
		public String toString() {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd@HH:mm:ss.SSS");
			return "RedisLock [lockKey=" + this.lockKey
					+ ",lockedAt=" + dateFormat.format(new Date(this.lockedAt))
					+ ", lockId=" + this.lockId
					+ "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((this.lockKey == null) ? 0 : this.lockKey.hashCode());
			result = prime * result + (int) (this.lockedAt ^ (this.lockedAt >>> 32));
			result = prime * result + this.lockId.hashCode();
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ReactiveRedisDistributedLock other = (ReactiveRedisDistributedLock) obj;
			if (!getOuterType().equals(other.getOuterType())) {
				return false;
			}
			if (!Objects.equals(this.lockKey,other.lockKey)) {
				return false;
			}
			if (!Objects.equals(this.lockId,other.lockId)) {
				return false;
			}
			return this.lockedAt == other.lockedAt;
		}

		private ReactiveRedisDistributedLockRegistry getOuterType() {
			return ReactiveRedisDistributedLockRegistry.this;
		}

		/**
		 * execute redis-script to obtain lock
		 * @return if obtain success then return true otherwise return false
		 */
		private Mono<Boolean> obtainLock() {
			return Mono.from(ReactiveRedisDistributedLockRegistry.this.reactiveStringRedisTemplate
							.execute(ReactiveRedisDistributedLockRegistry.this.obtainLockScript,
									Collections.singletonList(this.lockKey),
									List.of(this.lockId,String.valueOf(ReactiveRedisDistributedLockRegistry.this.expireAfter)))
					)
					.map(success -> {
						boolean result = Boolean.TRUE.equals(success);
						if (result) {
							this.lockedAt = System.currentTimeMillis();
						}
						return result;
					});
		}

		/**
		 * remove redis lock key
		 * @return
		 */
		private Mono<Boolean> removeLockKey() {
			return Mono.just(ReactiveRedisDistributedLockRegistry.this.unlinkAvailable)
					.filter(unlink -> unlink)
					.flatMap(unlink -> ReactiveRedisDistributedLockRegistry.this.reactiveStringRedisTemplate
							.unlink(this.lockKey)
							.doOnError(throwable -> {
								ReactiveRedisDistributedLockRegistry.this.unlinkAvailable = false;
								if (log.isDebugEnabled()) {
									log.debug("The UNLINK command has failed (not supported on the Redis server?); " +
											"falling back to the regular DELETE command", throwable);
								} else {
									log.warn("The UNLINK command has failed (not supported on the Redis server?); " +
											"falling back to the regular DELETE command: " + throwable.getMessage());
								}
							})
							.onErrorResume(throwable -> ReactiveRedisDistributedLockRegistry.this.reactiveStringRedisTemplate.delete(this.lockKey))
					)
					.switchIfEmpty(ReactiveRedisDistributedLockRegistry.this.reactiveStringRedisTemplate.delete(this.lockKey))
					.then(Mono.just(true));
		}

		/**
		 * rethrow lock exception
		 * @param e
		 */
		private void rethrowAsLockException(Throwable e) {
			throw new CannotAcquireLockException("Failed to lock mutex at " + this.lockKey, e);
		}

		/**
		 * check is the acquired is in this process
		 * @return
		 */
		Mono<Boolean> isAcquiredInThisProcess() {
			return ReactiveRedisDistributedLockRegistry.this.reactiveStringRedisTemplate.opsForValue()
					.get(this.lockKey)
					.map(this.lockId::equals);
		}

		@Override
		public Mono<Boolean> acquireOnce() {
			log.debug("Acquire Lock Once,LockKey:{}",this.lockKey);
			return this.obtainLock()
					.doOnNext(lockResult -> log.info("Obtain Lock Once,LockKey:{},Result:{}",this.lockKey,lockResult))
					.doOnError(this::rethrowAsLockException);
		}

		@Override
		public Mono<Boolean> acquire() {
			log.debug("Acquire Lock By Default Duration :{}" ,expireDuration);
			return this.acquire(ReactiveRedisDistributedLockRegistry.this.expireDuration);
		}

		@Override
		public Mono<Boolean> acquire(Duration duration) {
			return this.obtainLock()
					.filter(result -> result)
					.repeatWhenEmpty(Repeat.onlyIf(repeatContext -> true)
							.timeout(duration)
							.fixedBackoff(Duration.ofMillis(100))
							.doOnRepeat(objectRepeatContext -> {
								if (log.isTraceEnabled()) {
									log.trace("Repeat Acquire Lock Repeat Content:{}",objectRepeatContext);
								}
							})
					)
					.doOnNext(lockResult -> log.info("Obtain Lock,Lock Result :{},Lock Info:{}",lockResult,this))
					.doOnError(this::rethrowAsLockException)
					.switchIfEmpty(Mono.error(new CannotAcquireLockException("Failed to Obtain Lock ,LockKey: " + this.lockKey)));
		}

		@Override
		public Mono<Boolean> release() {
			return this.isAcquiredInThisProcess()
					.filter(isThisProcess -> isThisProcess)
					.flatMap(isThisProcess -> this.removeLockKey()
							.doOnNext(v -> log.info("Released Lock:{}",this))
							.onErrorResume(throwable -> Mono.fromRunnable(() -> ReflectionUtils.rethrowRuntimeException(throwable)))
							.switchIfEmpty(Mono.error(new IllegalStateException("Lock was released in the store due to expiration. " + "The integrity of data protected by this lock may have been compromised.")))
					);
		}

	}

}
