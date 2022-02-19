package pro.chenggang.project.reactive.lock.core;

import reactor.core.publisher.Mono;

/**
 * The Stateful reactive lock.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
public interface StatefulReactiveLock extends ReactiveLock {

    /**
     * the latest lock time
     *
     * @return long
     */
    long latestLockTime();

    /**
     * is the lock in process
     *
     * @return mono
     */
    Mono<Boolean> isInProcess();
}
