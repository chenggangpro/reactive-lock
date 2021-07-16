package pro.chenggang.project.reactive.redis.distributedlock.core;

import org.springframework.dao.CannotAcquireLockException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import java.time.Duration;

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
    Mono<Boolean> acquire(@NonNull Duration duration);

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
     * @param monoExecution to be executed subscribed to when lock is acquired
     * @return true if lock is acquired.
     * @see ReactiveDistributedLock#acquire()
     */
    default <T> Mono<T> acquireAndExecute(@NonNull Mono<T> monoExecution) {
        return acquire()
                .flatMap(acquireResult -> Mono.just(acquireResult)
                            .filter(result -> result)
                            .switchIfEmpty(Mono.error(new CannotAcquireLockException("Failed to Obtain Lock ,LockKey: " + getLockKey())))
                            .flatMap(lockResult -> monoExecution
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
     * @param monoExecution     to be executed subscribed to when lock is acquired
     * @return true, if lock is acquired
     * @see ReactiveDistributedLock#acquire(Duration)
     */
    default <T> Mono<T> acquireAndExecute(@NonNull Duration duration, @NonNull Mono<T> monoExecution) {
        return acquire(duration)
                .flatMap(acquireResult -> Mono.just(acquireResult)
                        .filter(result -> result)
                        .switchIfEmpty(Mono.error(new CannotAcquireLockException("Failed to Obtain Lock ,LockKey: " + getLockKey())))
                        .flatMap(lockResult -> monoExecution
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
     * @param fluxExecution  to be executed subscribed to when lock is acquired
     * @return true if lock is acquired.
     * @see ReactiveDistributedLock#acquire()
     */
    default <T> Flux<T> acquireAndExecuteMany(@NonNull Flux<T> fluxExecution) {
        return acquire()
                .flatMapMany(acquireResult -> Mono.just(acquireResult)
                        .filter(result -> result)
                        .switchIfEmpty(Mono.error(new CannotAcquireLockException("Failed to Obtain Lock ,LockKey: " + getLockKey())))
                        .flatMapMany(lockResult -> fluxExecution
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
     * @param fluxExecution  to be executed subscribed to when lock is acquired
     * @return true, if lock is acquired
     * @see ReactiveDistributedLock#acquire(Duration)
     */
    default <T> Flux<T> acquireAndExecuteMany(@NonNull Duration duration, @NonNull Flux<T> fluxExecution) {
        return acquire(duration)
                .flatMapMany(acquireResult -> Mono.just(acquireResult)
                        .filter(result -> result)
                        .switchIfEmpty(Mono.error(new CannotAcquireLockException("Failed to Obtain Lock ,LockKey: " + getLockKey())))
                        .flatMapMany(lockResult -> fluxExecution
                                .flatMap(result -> this.release()
                                        .flatMap(releaseResult -> Mono.just(result))
                                )
                                .switchIfEmpty(this.release().thenMany(Flux.empty()))
                                .onErrorResume(throwable -> this.release().flatMap(r -> Mono.error(throwable)))
                        )
                );
    }

}
