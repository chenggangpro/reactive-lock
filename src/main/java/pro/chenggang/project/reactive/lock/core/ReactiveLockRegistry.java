package pro.chenggang.project.reactive.lock.core;

/**
 * The Reactive lock registry.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
public interface ReactiveLockRegistry {

    /**
     * default lock key (unique)
     */
    String DEFAULT_LOCK_KEY = "@@REACTIVE_LOCK_DEFAULT_KEY@@";

    /**
     * obtain lock by default lock key
     *
     * @return reactive lock
     */
    default ReactiveLock obtain() {
        return obtain(DEFAULT_LOCK_KEY);
    }

    /**
     * obtain lock by lock key
     *
     * @param lockKey the lock key
     * @return reactive lock
     */
    ReactiveLock obtain(String lockKey);
}
