package pro.chenggang.project.reactive.lock.core.clh;

import pro.chenggang.project.reactive.lock.core.StatefulReactiveLock;
import pro.chenggang.project.reactive.lock.core.common.AbstractAutoCleanupReactiveLockRegistry;

import java.time.Duration;

/**
 * The CLH reactive lock registry.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
public class CLHReactiveLockRegistry extends AbstractAutoCleanupReactiveLockRegistry {

    /**
     * Instantiates a new Default reactive lock registry.
     */
    public CLHReactiveLockRegistry() {
        this(DEFAULT_EXPIRE_EVICT_IDLE, DEFAULT_MAX_LOCK_LIFETIME);
    }

    /**
     * Instantiates a new Default reactive lock registry.
     *
     * @param expireEvictIdle the expire evict idle
     * @param maxLockLifeTime the max lock lifetime
     */
    public CLHReactiveLockRegistry(Duration expireEvictIdle, Duration maxLockLifeTime) {
        super(expireEvictIdle, maxLockLifeTime);
    }

    @Override
    protected StatefulReactiveLock newReactiveLock(String lockKey) {
        return new CLHJvmReactiveLock();
    }
}
