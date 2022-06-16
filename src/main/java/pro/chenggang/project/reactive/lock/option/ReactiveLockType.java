package pro.chenggang.project.reactive.lock.option;

/**
 * The Reactive lock type.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
public enum ReactiveLockType {

    /**
     * default reactive lock type
     */
    DEFAULT,

    /**
     * redis reactive lock
     */
    REDIS,

    /**
     * jvm reactive lock with CLH algorithm
     */
    CLH,
}
