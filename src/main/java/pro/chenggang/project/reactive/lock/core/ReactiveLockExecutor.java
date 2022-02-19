package pro.chenggang.project.reactive.lock.core;

import reactor.core.publisher.Mono;

/**
 * The Reactive lock executor.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
public interface ReactiveLockExecutor {

    /**
     * get lock time in Mills
     *
     * @return long
     */
    long lockAt();

    /**
     * is in process
     *
     * @return mono
     */
    Mono<Boolean> isInProcess();

    /**
     * obtain once
     *
     * @return mono
     */
    Mono<Boolean> obtain();

    /**
     * release lock
     *
     * @return mono
     */
    Mono<Boolean> release();
}
