package pro.chenggang.project.reactive.lock.core;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Function;

/**
 * @author: chenggang
 * @date 11/26/21.
 */
public interface ReactiveLock {

    /**
     * Try to acquire the lock once
     * @param lockResultExecution apply lockResult return executable Mono
     * @param <T> Mono type
     * @return executable Mono
     */
    <T> Mono<T> tryLockThenExecute(@NotNull Function<Boolean, Mono<T>> lockResultExecution);

    /**
     * Try to acquire the lock once
     * @param lockResultExecution apply lockResult return executable Flux
     * @param <T> Flux type
     * @return executable Flux
     */
    <T> Flux<T> tryLockThenExecuteMany(@NotNull Function<Boolean, Flux<T>> lockResultExecution);

    /**
     * Try to acquire the lock for a given duration.
     * @param duration lock expire duration
     * @param lockResultExecution apply lockResult return executable Mono
     * @param <T> Mono type
     * @return executable Mono
     */
    <T> Mono<T> lockThenExecute(@NotNull Duration duration, @NotNull Function<Boolean, Mono<T>> lockResultExecution);

    /**
     * Try to acquire the lock for a given duration.
     * @param duration lock expire duration
     * @param lockResultExecution apply lockResult return executable Flux
     * @param <T> Flux type
     * @return executable Flux
     */
    <T> Flux<T> lockThenExecuteMany(@NotNull Duration duration, @NotNull Function<Boolean, Flux<T>> lockResultExecution);

}
