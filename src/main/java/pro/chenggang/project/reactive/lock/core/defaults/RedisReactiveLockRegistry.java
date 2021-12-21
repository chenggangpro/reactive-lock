package pro.chenggang.project.reactive.lock.core.defaults;

import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import pro.chenggang.project.reactive.lock.core.StatefulReactiveLock;

import java.time.Duration;
import java.util.Objects;

/**
 * @author: chenggang
 * @date 12/21/21.
 */
public class RedisReactiveLockRegistry extends AbstractAutoCleanupReactiveLockRegistry {

    private final String DEFAULT_KEY_PREFIX = "REDIS_REACTIVE_LOCK";
    private final ReactiveRedisConnectionFactory reactiveRedisConnectionFactory;
    private final Duration maxLockLifeTime;
    private final String keyPrefix;

    public RedisReactiveLockRegistry(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, String keyPrefix) {
        this(reactiveRedisConnectionFactory,DEFAULT_EXPIRE_EVICT_IDLE, DEFAULT_MAX_LOCK_LIFETIME, keyPrefix);
    }

    public RedisReactiveLockRegistry(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, Duration expireEvictIdle, Duration maxLockLifeTime, String keyPrefix) {
        super(expireEvictIdle, maxLockLifeTime);
        this.reactiveRedisConnectionFactory = reactiveRedisConnectionFactory;
        this.maxLockLifeTime = maxLockLifeTime;
        if(Objects.nonNull(keyPrefix) && keyPrefix.length() > 0){
            this.keyPrefix = keyPrefix;
        }else {
            this.keyPrefix = DEFAULT_KEY_PREFIX;
        }
    }

    @Override
    protected StatefulReactiveLock newReactiveLock(String lockKey) {
        return new RedisReactiveLock(this.reactiveRedisConnectionFactory,this.keyPrefix + ':' + lockKey,this.maxLockLifeTime);
    }
}
