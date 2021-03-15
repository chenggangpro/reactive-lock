package pro.chenggang.project.reactive.redis.distributedlock.core;

import org.springframework.dao.CannotAcquireLockException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Supplier;

/**
 * A reactive distributed lock with Reactor API.
 * @author evans
 * @date 2021/03/14
 */
public interface ReactiveDistributedLock {

    /**
     * get lock Key
     * @return
     */
    String getLockKey();

    /**
     * Try to acquire the lock once. Lock is acquired for a pre configured duration.
     * @return if lock succeeded then return true otherwise return false
     * <strong>if flow is empty default return false</strong>
     */
    Mono<Boolean> acquireOnce();

    /**
     * Try to acquire the lock. Lock is acquired for a pre configured duration.
     * @return
     * <strong>if flow is empty then throw an excpetion {@link CannotAcquireLockException}</strong>
     */
    Mono<Boolean> acquire();

    /**
     * Try to acquire the lock for a given duration.
     * @param duration duration in used
     * @return
     * <strong>the given duration must less than the default duration.Otherwise the lockKey well be expire by redis with default expire duration</strong>
     * <strong>if flow is empty then throw an excpetion {@link CannotAcquireLockException}</strong>
     */
    Mono<Boolean> acquire(Duration duration);

    /**
     * Release the lock.
     * @return
     * <strong>if lock key doesn't exist in the redis,then throw an exception {@link IllegalStateException}</strong>
     */
    Mono<Boolean> release();

    /**
     * Acquire a lock and release it after action is executed or fails.
     *
     * @param <T>  type od value emitted by the action
     * @param executionSupplier to be executed subscribed to when lock is acquired
     * @return true if lock is acquired.
     * @see ReactiveDistributedLock#acquire()
     */
    default <T> Mono<T> acquireAndExecute(Supplier<Mono<T>> executionSupplier) {
        return acquire()
                .flatMap(acquireResult -> Mono.just(acquireResult)
                            .filter(result -> result)
                            .switchIfEmpty(Mono.error(new CannotAcquireLockException("Failed to Obtain Lock ,LockKey: " + getLockKey())))
                            .flatMap(lockResult -> executionSupplier
                                    .get()
                                    .flatMap(result -> this.release()
                                            .flatMap(releaseResult -> Mono.just(result))
                                    )
                                    .switchIfEmpty(this.release().then(Mono.empty()))
                                    .onErrorResume(throwable -> this.release().flatMap(r -> Mono.error(throwable)))
                            )
                );
    }

    /**
     * Acquire a lock for a given duration and release it after action is executed.
     *
     * @param <T>      type od value emitted by the action
     * @param duration how much time must pass for the acquired lock to expire
     * @param executionSupplier     to be executed subscribed to when lock is acquired
     * @return true, if lock is acquired
     * @see ReactiveDistributedLock#acquire(Duration)
     */
    default <T> Mono<T> acquireAndExecute(Duration duration, Supplier<Mono<T>> executionSupplier) {
        return acquire(duration)
                .flatMap(acquireResult -> Mono.just(acquireResult)
                        .filter(result -> result)
                        .switchIfEmpty(Mono.error(new CannotAcquireLockException("Failed to Obtain Lock ,LockKey: " + getLockKey())))
                        .flatMap(lockResult -> executionSupplier
                                .get()
                                .flatMap(result -> this.release()
                                        .flatMap(releaseResult -> Mono.just(result))
                                )
                                .switchIfEmpty(this.release().then(Mono.empty()))
                                .onErrorResume(throwable -> this.release().flatMap(r -> Mono.error(throwable)))
                        )
                );
    }

    /**
     * Acquire a lock and release it after action is executed or fails.
     *
     * @param <T>  type od value emitted by the action
     * @param executionSupplier     to be executed subscribed to when lock is acquired
     * @return true if lock is acquired.
     * @see ReactiveDistributedLock#acquire()
     */
    default <T> Flux<T> acquireAndExecuteMany(Supplier<Flux<T>> executionSupplier) {
        return acquire()
                .flatMapMany(acquireResult -> Mono.just(acquireResult)
                        .filter(result -> result)
                        .switchIfEmpty(Mono.error(new CannotAcquireLockException("Failed to Obtain Lock ,LockKey: " + getLockKey())))
                        .flatMapMany(lockResult -> executionSupplier
                                .get()
                                .flatMap(result -> this.release()
                                        .flatMap(releaseResult -> Mono.just(result))
                                )
                                .switchIfEmpty(this.release().thenMany(Flux.empty()))
                                .onErrorResume(throwable -> this.release().flatMap(r -> Mono.error(throwable)))
                        )
                );
    }

    /**
     * Acquire a lock for a given duration and release it after action is executed.
     *
     * @param <T>      type od value emitted by the action
     * @param duration how much time must pass for the acquired lock to expire
     * @param executionSupplier     to be executed subscribed to when lock is acquired
     * @return true, if lock is acquired
     * @see ReactiveDistributedLock#acquire(Duration)
     */
    default <T> Flux<T> acquireAndExecuteMany(Duration duration, Supplier<Flux<T>> executionSupplier) {
        return acquire(duration)
                .flatMapMany(acquireResult -> Mono.just(acquireResult)
                        .filter(result -> result)
                        .switchIfEmpty(Mono.error(new CannotAcquireLockException("Failed to Obtain Lock ,LockKey: " + getLockKey())))
                        .flatMapMany(lockResult -> executionSupplier
                                .get()
                                .flatMap(result -> this.release()
                                        .flatMap(releaseResult -> Mono.just(result))
                                )
                                .switchIfEmpty(this.release().thenMany(Flux.empty()))
                                .onErrorResume(throwable -> this.release().flatMap(r -> Mono.error(throwable)))
                        )
                );
    }

}
