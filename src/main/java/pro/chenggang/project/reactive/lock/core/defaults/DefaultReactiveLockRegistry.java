package pro.chenggang.project.reactive.lock.core.defaults;

import pro.chenggang.project.reactive.lock.core.StatefulReactiveLock;

import java.time.Duration;

/**
 * @author: chenggang
 * @date 12/21/21.
 */
public class DefaultReactiveLockRegistry extends AbstractAutoCleanupReactiveLockRegistry {

    public DefaultReactiveLockRegistry() {
        this(DEFAULT_EXPIRE_EVICT_IDLE, DEFAULT_MAX_LOCK_LIFETIME);
    }

    public DefaultReactiveLockRegistry(Duration expireEvictIdle, Duration maxLockLifeTime) {
        super(expireEvictIdle, maxLockLifeTime);
    }

    @Override
    protected StatefulReactiveLock newReactiveLock(String lockKey) {
        return new DefaultReactiveLock();
    }
}
