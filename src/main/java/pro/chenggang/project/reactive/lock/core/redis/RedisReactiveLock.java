package pro.chenggang.project.reactive.lock.core.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import pro.chenggang.project.reactive.lock.core.ReactiveLockExecutor;
import pro.chenggang.project.reactive.lock.core.common.AbstractReactiveLock;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The Redis reactive lock.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
@Slf4j
public class RedisReactiveLock extends AbstractReactiveLock {

    private static final Duration DEFAULT_EXPIRE_AFTER = Duration.ofSeconds(60);
    private static final String OBTAIN_LOCK_SCRIPT = "local lockSet = redis.call('SETNX', KEYS[1], ARGV[1])\n" +
            "if lockSet == 1 then\n" +
            "  redis.call('PEXPIRE', KEYS[1], ARGV[2])\n" +
            "  redis.call('SETNX', ARGV[1], 'true')\n" +
            "  redis.call('PEXPIRE', ARGV[1], ARGV[2])\n" +
            "  return true\n" +
            "else\n" +
            "  return false\n" +
            "end";
    private final RedisScript<Boolean> obtainLockScript = new DefaultRedisScript<>(OBTAIN_LOCK_SCRIPT, Boolean.class);
    private final ReactiveStringRedisTemplate reactiveStringRedisTemplate;
    private final ReactiveLockExecutor reactiveLockExecutor;
    private volatile boolean unlinkAvailable = true;

    /**
     * Instantiates a new Redis reactive lock.
     *
     * @param reactiveRedisConnectionFactory the reactive redis connection factory
     * @param lockKey                        the lock key
     * @param expireAfter                    the expire after
     */
    public RedisReactiveLock(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, String lockKey, Duration expireAfter) {
        Assert.notNull(reactiveRedisConnectionFactory, "ReactiveRedisConnectionFactory cannot be null");
        Assert.notNull(lockKey, "'lockKey' cannot be null");
        this.reactiveStringRedisTemplate = new ReactiveStringRedisTemplate(reactiveRedisConnectionFactory);
        this.reactiveLockExecutor = new RedisReactiveLockExecutor(lockKey, expireAfter == null ? DEFAULT_EXPIRE_AFTER : expireAfter);
    }

    @Override
    protected ReactiveLockExecutor getReactiveLockExecutor() {
        return this.reactiveLockExecutor;
    }

    @Override
    public long latestLockTime() {
        return this.reactiveLockExecutor.lockAt();
    }

    @Override
    public Mono<Boolean> isInProcess() {
        return this.reactiveLockExecutor.isInProcess();
    }

    private class RedisReactiveLockExecutor implements ReactiveLockExecutor {

        private final String lockKey;
        private final long expireAfter;
        private volatile long lockedAt;

        /**
         * Instantiates a new Redis reactive lock executor.
         *
         * @param lockKey     the lock key
         * @param expireAfter the expire after
         */
        public RedisReactiveLockExecutor(String lockKey, Duration expireAfter) {
            Assert.notNull(lockKey, "'lockKey' cannot be null");
            this.lockKey = lockKey;
            this.expireAfter = expireAfter.toMillis();
        }

        @Override
        public long lockAt() {
            return this.lockedAt;
        }

        @Override
        public Mono<Boolean> isInProcess() {
            return Mono.zip(isLockInProcess(),
                            isContextInProcess()
                    )
                    .map(tuple -> tuple.getT1() && tuple.getT2());

        }

        /**
         * whether current lock is in process
         *
         * @return if ture when in process
         */
        private Mono<Boolean> isLockInProcess() {
            return RedisReactiveLock.this.reactiveStringRedisTemplate.opsForValue()
                    .get(this.lockKey)
                    .map(StringUtils::hasText)
                    .defaultIfEmpty(false);
        }

        /**
         * whether current context is in process
         *
         * @return if ture when in process
         */
        private Mono<Boolean> isContextInProcess() {
            return Mono.deferContextual(contextView -> Mono
                    .justOrEmpty(contextView.getOrEmpty(REACTIVE_LOCK_CONTEXT_ID_KEY))
                    .ofType(String.class)
                    .switchIfEmpty(Mono.error(new IllegalStateException("Could not found redis lock context id when check whether a lock  is in process")))
                    .flatMap(contextId -> RedisReactiveLock.this.reactiveStringRedisTemplate.opsForValue()
                            .get(contextId)
                            .filter(StringUtils::hasText)
                            .map("true"::equals)
                            .defaultIfEmpty(false)
                    )
            );
        }

        @Override
        public Mono<Boolean> obtain() {
            return Mono.deferContextual(contextView -> Mono
                    .justOrEmpty(contextView.getOrEmpty(REACTIVE_LOCK_CONTEXT_ID_KEY))
                    .ofType(String.class)
                    .switchIfEmpty(Mono.error(new IllegalStateException("Could not found redis lock context id when obtain a lock")))
                    .flatMap(contextId -> Mono
                            .from(RedisReactiveLock.this.reactiveStringRedisTemplate.execute(RedisReactiveLock.this.obtainLockScript,
                                    Collections.singletonList(this.lockKey),
                                    List.of(contextId, String.valueOf(this.expireAfter)))
                            )
                            .map(success -> {
                                boolean result = Boolean.TRUE.equals(success);
                                if (result) {
                                    this.lockedAt = System.currentTimeMillis();
                                }
                                return result;
                            })
                    ));
        }

        @Override
        public Mono<Boolean> release() {
            return Mono.deferContextual(contextView -> Mono
                            .justOrEmpty(contextView.getOrEmpty(REACTIVE_LOCK_CONTEXT_ID_KEY))
                            .ofType(String.class)
                            .switchIfEmpty(Mono.error(new IllegalStateException("Could not found redis lock context id when release a lock")))
                            .flatMap(contextId -> Mono.just(RedisReactiveLock.this.unlinkAvailable)
                                    //if unlink is supported
                                    .filter(isUnlinkSupported -> isUnlinkSupported)
                                    .flatMap(unlink -> this.isContextInProcess()
                                            .filter(isContextInProcess -> isContextInProcess)
                                            .flatMap(isContextInProcess -> this.isLockInProcess()
                                                    .filter(isLockInProcess -> isLockInProcess)
                                                    .flatMap(isLockInProcess ->  Mono
                                                            .zip(
                                                                    RedisReactiveLock.this.reactiveStringRedisTemplate.unlink(this.lockKey),
                                                                    RedisReactiveLock.this.reactiveStringRedisTemplate.unlink(contextId)
                                                            )
                                                            .map(tuple -> tuple.getT1() + tuple.getT2())
                                                            .doOnError(throwable -> {
                                                                RedisReactiveLock.this.unlinkAvailable = false;
                                                                if (log.isDebugEnabled()) {
                                                                    log.debug("The UNLINK command has failed (not supported on the Redis server?); " +
                                                                            "falling back to the regular DELETE command", throwable);
                                                                } else {
                                                                    log.warn("The UNLINK command has failed (not supported on the Redis server?); " +
                                                                            "falling back to the regular DELETE command: " + throwable.getMessage());
                                                                }
                                                            })
                                                            .map(unlinkResult -> unlinkResult > 0)
                                                            .onErrorResume(throwable -> Mono
                                                                    .zip(
                                                                            RedisReactiveLock.this.reactiveStringRedisTemplate.unlink(this.lockKey),
                                                                            RedisReactiveLock.this.reactiveStringRedisTemplate.unlink(contextId)
                                                                    )
                                                                    .map(tuple -> tuple.getT1() + tuple.getT2())
                                                                    .map(unlinkResult -> unlinkResult > 0)
                                                            )
                                                    )
                                                    .switchIfEmpty(Mono.defer(() -> {
                                                        log.warn("Lock({}) was released in the store due to expiration." +
                                                                "The integrity of data protected by this lock may have been compromised.", this.lockKey);
                                                        return Mono.just(false);
                                                    }))
                                            )
                                            .switchIfEmpty(Mono.just(true))
                                    )
                                    //if unlink is not supported
                                    .switchIfEmpty(Mono.defer(() -> this.isContextInProcess()
                                                    .filter(isContextInProcess -> isContextInProcess)
                                                    .flatMap(isContextInProcess -> this.isLockInProcess()
                                                            .filter(isLockInProcess -> isLockInProcess)
                                                            .flatMap(isLockInProcess ->  Mono
                                                                    .zip(
                                                                            RedisReactiveLock.this.reactiveStringRedisTemplate.delete(this.lockKey),
                                                                            RedisReactiveLock.this.reactiveStringRedisTemplate.delete(contextId)
                                                                    )
                                                                    .map(tuple -> tuple.getT1() + tuple.getT2())
                                                                    .map(unlinkResult -> unlinkResult > 0)
                                                                    .onErrorResume(throwable -> Mono
                                                                            .zip(
                                                                                    RedisReactiveLock.this.reactiveStringRedisTemplate.delete(this.lockKey),
                                                                                    RedisReactiveLock.this.reactiveStringRedisTemplate.delete(contextId)
                                                                            )
                                                                            .map(tuple -> tuple.getT1() + tuple.getT2())
                                                                            .map(unlinkResult -> unlinkResult > 0)
                                                                    )
                                                            )
                                                            .switchIfEmpty(Mono.defer(() -> {
                                                                log.warn("Lock({}) was released in the store due to expiration." +
                                                                        "The integrity of data protected by this lock may have been compromised.", this.lockKey);
                                                                return Mono.just(false);
                                                            }))
                                                    )
                                                    .switchIfEmpty(Mono.just(true))
                                            )
                                    ))
                    )
                    .switchIfEmpty(Mono.just(false));
        }

        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd@HH:mm:ss.SSS");
            return "RedisReactiveLockExecutor [lockKey=" + this.lockKey
                    + ",lockedAt=" + dateFormat.format(new Date(this.lockedAt))
                    + "]";
        }
    }
}