package pro.chenggang.project.reactive.lock.core;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Function;

/**
 * The Reactive lock.
 *
 * @author Gang Cheng
 * @date 11 /26/21.
 */
public interface ReactiveLock {

    /**
     * Try to acquire the lock once
     *
     * @param <T>                 Mono Execution
     * @param lockResultExecution apply lockResult return executable Mono
     * @return executable Mono
     */
    <T> Mono<T> tryLockThenExecute(@NotNull Function<Boolean, Mono<T>> lockResultExecution);

    /**
     * Try to acquire the lock once
     *
     * @param <T>                 Flux Execution
     * @param lockResultExecution apply lockResult return executable Flux
     * @return executable Flux
     */
    <T> Flux<T> tryLockThenExecuteMany(@NotNull Function<Boolean, Flux<T>> lockResultExecution);

    /**
     * Try to acquire the lock for a given duration.
     *
     * @param <T>                 Mono Execution
     * @param duration            lock expire duration
     * @param lockResultExecution apply lockResult return executable Mono
     * @return executable Mono
     */
    <T> Mono<T> lockThenExecute(@NotNull Duration duration, @NotNull Function<Boolean, Mono<T>> lockResultExecution);

    /**
     * Try to acquire the lock for a given duration.
     *
     * @param <T>                 Flux Execution
     * @param duration            lock expire duration
     * @param lockResultExecution apply lockResult return executable Flux
     * @return executable Flux
     */
    <T> Flux<T> lockThenExecuteMany(@NotNull Duration duration, @NotNull Function<Boolean, Flux<T>> lockResultExecution);

}
