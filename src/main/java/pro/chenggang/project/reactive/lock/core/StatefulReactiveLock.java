package pro.chenggang.project.reactive.lock.core;

import reactor.core.publisher.Mono;

/**
 * @author: chenggang
 * @date 12/21/21.
 */
public interface StatefulReactiveLock extends ReactiveLock{

    /**
     * get latestLock time
     * @return
     */
    long latestLockTime();

    /**
     * is in process
     * @return
     */
    Mono<Boolean> isInProcess();
}
