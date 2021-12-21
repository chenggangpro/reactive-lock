package pro.chenggang.project.reactive.lock.core.defaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.util.Assert;
import pro.chenggang.project.reactive.lock.core.ReactiveLockExecutor;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: chenggang
 * @date 12/21/21.
 */
@Slf4j
public class RedisReactiveLock extends AbstractReactiveLock {

    private static final Duration DEFAULT_EXPIRE_AFTER = Duration.ofSeconds(60);
    private static final String OBTAIN_LOCK_SCRIPT = "local lockSet = redis.call('SETNX', KEYS[1], ARGV[1])\n" +
            "if lockSet == 1 then\n" +
            "  redis.call('PEXPIRE', KEYS[1], ARGV[2])\n" +
            "  return true\n" +
            "else\n" +
            "  return false\n" +
            "end";
    private final RedisScript<Boolean> obtainLockScript = new DefaultRedisScript<>(OBTAIN_LOCK_SCRIPT, Boolean.class);
    private final ReactiveStringRedisTemplate reactiveStringRedisTemplate;
    private final ReactiveLockExecutor reactiveLockExecutor;
    private volatile boolean unlinkAvailable = true;

    public RedisReactiveLock(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, String lockKey, Duration expireAfter) {
        Assert.notNull(reactiveRedisConnectionFactory, "ReactiveRedisConnectionFactory cannot be null");
        Assert.notNull(lockKey, "'lockKey' cannot be null");
        this.reactiveStringRedisTemplate = new ReactiveStringRedisTemplate(reactiveRedisConnectionFactory);
        this.reactiveLockExecutor = new RedisReactiveLockExecutor(lockKey,expireAfter == null ? DEFAULT_EXPIRE_AFTER : expireAfter);
    }

    @Override
    protected ReactiveLockExecutor getReactiveLockData() {
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

        private final String lockId = UUID.randomUUID().toString();
        private final String lockKey;
        private final long expireAfter;
        private volatile long lockedAt;

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
            return RedisReactiveLock.this.reactiveStringRedisTemplate.opsForValue()
                    .get(this.lockKey)
                    .map(this.lockId::equals);
        }

        @Override
        public Mono<Boolean> obtain() {
            return Mono
                    .from(RedisReactiveLock.this.reactiveStringRedisTemplate.execute(RedisReactiveLock.this.obtainLockScript,
                            Collections.singletonList(this.lockKey),
                            List.of(this.lockId,String.valueOf(this.expireAfter)))
                    )
                    .map(success -> {
                        boolean result = Boolean.TRUE.equals(success);
                        if (result) {
                            this.lockedAt = System.currentTimeMillis();
                        }
                        return result;
                    });
        }

        @Override
        public Mono<Boolean> release() {
            return Mono.just(RedisReactiveLock.this.unlinkAvailable)
                    .filter(unlink -> unlink)
                    .flatMap(unlink -> RedisReactiveLock.this.reactiveStringRedisTemplate
                            .unlink(this.lockKey)
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
                            .onErrorResume(throwable -> RedisReactiveLock.this.reactiveStringRedisTemplate.delete(this.lockKey))
                    )
                    .switchIfEmpty(RedisReactiveLock.this.reactiveStringRedisTemplate.delete(this.lockKey))
                    .then(Mono.just(true));
        }

        @Override
        public String toString() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd@HH:mm:ss.SSS");
            return "RedisReactiveLockExecutor [lockKey=" + this.lockKey
                    + ",lockedAt=" + dateFormat.format(new Date(this.lockedAt))
                    + ", lockId=" + this.lockId
                    + "]";
        }
    }
}
