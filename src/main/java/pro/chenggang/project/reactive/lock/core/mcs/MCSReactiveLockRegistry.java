package pro.chenggang.project.reactive.lock.core.mcs;

import pro.chenggang.project.reactive.lock.core.StatefulReactiveLock;
import pro.chenggang.project.reactive.lock.core.defaults.AbstractAutoCleanupReactiveLockRegistry;

import java.time.Duration;

/**
 * The MCS reactive lock registry.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
public class MCSReactiveLockRegistry extends AbstractAutoCleanupReactiveLockRegistry {

    /**
     * Instantiates a new Default reactive lock registry.
     */
    public MCSReactiveLockRegistry() {
        this(DEFAULT_EXPIRE_EVICT_IDLE, DEFAULT_MAX_LOCK_LIFETIME);
    }

    /**
     * Instantiates a new Default reactive lock registry.
     *
     * @param expireEvictIdle the expire evict idle
     * @param maxLockLifeTime the max lock lifetime
     */
    public MCSReactiveLockRegistry(Duration expireEvictIdle, Duration maxLockLifeTime) {
        super(expireEvictIdle, maxLockLifeTime);
    }

    @Override
    protected StatefulReactiveLock newReactiveLock(String lockKey) {
        return new MCSJvmReactiveLock();
    }
}
