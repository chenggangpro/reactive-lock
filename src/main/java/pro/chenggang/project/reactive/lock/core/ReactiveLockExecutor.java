package pro.chenggang.project.reactive.lock.core;

import reactor.core.publisher.Mono;

/**
 * @author: chenggang
 * @date 12/21/21.
 */
public interface ReactiveLockExecutor {

    /**
     * get lock time in Mills
     * @return
     */
    long lockAt();

    /**
     * is in process
     * @return
     */
    Mono<Boolean> isInProcess();

    /**
     * obtain once
     * @return
     */
    Mono<Boolean> obtain();

    /**
     * release lock
     * @return
     */
    Mono<Boolean> release();
}
