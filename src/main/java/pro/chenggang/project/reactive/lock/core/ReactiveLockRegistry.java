package pro.chenggang.project.reactive.lock.core;

/**
 * @author: chenggang
 * @date 12/21/21.
 */
public interface ReactiveLockRegistry {

    /**
     * default lock key (unique)
     */
    String DEFAULT_LOCK_KEY = "@@REACTIVE_LOCK_DEFAULT_KEY@@";

    /**
     * obtain lock by default key
     * @return
     */
    default ReactiveLock obtain(){
        return obtain(DEFAULT_LOCK_KEY);
    }

    /**
     * obtain lock by lock key
     * @param lockKey
     * @return
     */
    ReactiveLock obtain(String lockKey);
}
