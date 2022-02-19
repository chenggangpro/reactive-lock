package pro.chenggang.project.reactive.lock.core.defaults;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pro.chenggang.project.reactive.lock.core.ReactiveLockExecutor;
import pro.chenggang.project.reactive.lock.core.StatefulReactiveLock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.retry.Repeat;

import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

/**
 * The Abstract reactive lock.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
@Slf4j
public abstract class AbstractReactiveLock implements StatefulReactiveLock {

    @Override
    public <T> Mono<T> tryLockThenExecute(@NotNull Function<Boolean, Mono<T>> lockResultExecution) {
        return this.executeWithMono(null, lockResultExecution);
    }

    @Override
    public <T> Flux<T> tryLockThenExecuteMany(@NotNull Function<Boolean, Flux<T>> lockResultExecution) {
        return this.executeWithFlux(null, lockResultExecution);
    }

    @Override
    public <T> Mono<T> lockThenExecute(@NotNull Duration duration, @NotNull Function<Boolean, Mono<T>> lockResultExecution) {
        return this.executeWithMono(duration, lockResultExecution);
    }

    @Override
    public <T> Flux<T> lockThenExecuteMany(@NotNull Duration duration, @NotNull Function<Boolean, Flux<T>> lockResultExecution) {
        return this.executeWithFlux(duration, lockResultExecution);
    }

    /**
     * get reactive lock data
     *
     * @return reactive lock data
     */
    protected abstract ReactiveLockExecutor getReactiveLockExecutor();

    /**
     * execute with flux
     *
     * @param <T>                 the type parameter
     * @param lockExpireTime      the lock expire time
     * @param lockResultExecution the lock result execution
     * @return flux
     */
    protected <T> Flux<T> executeWithFlux(@Nullable Duration lockExpireTime, Function<Boolean, Flux<T>> lockResultExecution) {
        if (Objects.isNull(lockExpireTime) || lockExpireTime.isNegative()) {
            return Flux.usingWhen(
                    Mono.just(this.getReactiveLockExecutor()),
                    reactiveLockExecutor -> reactiveLockExecutor.obtain()
                            .filter(result -> result)
                            .defaultIfEmpty(false)
                            .doOnNext(lockResult -> log.info("[Flux Execution]Try lock once,LockResult:{}", lockResult))
                            .flatMapMany(lockResultExecution),
                    reactiveLockExecutor -> reactiveLockExecutor.release()
                            .doOnNext(releaseResult -> log.info("[Flux Execution](Normal Release) ReleaseResult:{}", releaseResult)),
                    (reactiveLockExecutor, err) -> reactiveLockExecutor.release()
                            .doOnNext(releaseResult -> log.info("[Flux Execution](When ERROR Release)ReleaseResult:{}", releaseResult)),
                    reactiveLockExecutor -> reactiveLockExecutor.release()
                            .doOnNext(releaseResult -> log.info("[Flux Execution](When AsyncCancel Release),ReleaseResult:{}", releaseResult))
            );
        }
        return Flux.usingWhen(
                Mono.just(this.getReactiveLockExecutor()),
                reactiveLockExecutor -> reactiveLockExecutor.obtain()
                        .filter(result -> result)
                        .repeatWhenEmpty(Repeat.<T>onlyIf(repeatContext -> true)
                                .timeout(lockExpireTime)
                                .fixedBackoff(Duration.ofMillis(100))
                                .doOnRepeat(objectRepeatContext -> {
                                    if (log.isTraceEnabled()) {
                                        log.trace("[Flux Execution]Repeat Acquire Lock Repeat Content:{}", objectRepeatContext);
                                    }
                                })
                        )
                        .defaultIfEmpty(false)
                        .doOnNext(lockResult -> log.info("[Flux Execution]Try lock,LockResult:{}", lockResult))
                        .flatMapMany(lockResultExecution),
                reactiveLockExecutor -> reactiveLockExecutor.release()
                        .doOnNext(releaseResult -> log.info("[Flux Execution](Normal Release) ReleaseResult:{}", releaseResult)),
                (reactiveLockExecutor, err) -> reactiveLockExecutor.release()
                        .doOnNext(releaseResult -> log.info("[Flux Execution](When ERROR Release)ReleaseResult:{}", releaseResult)),
                reactiveLockExecutor -> reactiveLockExecutor.release()
                        .doOnNext(releaseResult -> log.info("[Flux Execution](When AsyncCancel Release),ReleaseResult:{}", releaseResult))
        );
    }

    /**
     * execute with mono
     *
     * @param <T>                 the type parameter
     * @param lockExpireTime      the lock expire time
     * @param lockResultExecution the lock result execution
     * @return mono
     */
    protected <T> Mono<T> executeWithMono(@Nullable Duration lockExpireTime, Function<Boolean, Mono<T>> lockResultExecution) {
        if (Objects.isNull(lockExpireTime) || lockExpireTime.isNegative()) {
            return Mono.usingWhen(
                    Mono.just(this.getReactiveLockExecutor()),
                    reactiveLockExecutor -> reactiveLockExecutor.obtain()
                            .filter(result -> result)
                            .defaultIfEmpty(false)
                            .doOnNext(lockResult -> log.info("[Mono Execution]Try lock once,LockResult:{}", lockResult))
                            .flatMap(lockResultExecution),
                    reactiveLockExecutor -> reactiveLockExecutor.release()
                            .doOnNext(releaseResult -> log.info("[Mono Execution(Normal Release) ReleaseResult:{}", releaseResult)),
                    (reactiveLockExecutor, err) -> reactiveLockExecutor.release()
                            .doOnNext(releaseResult -> log.info("[Mono Execution(When ERROR Release)ReleaseResult:{}", releaseResult)),
                    reactiveLockExecutor -> reactiveLockExecutor.release()
                            .doOnNext(releaseResult -> log.info("[Mono Execution(When AsyncCancel Release),ReleaseResult:{}", releaseResult))
            );
        }
        return Mono.usingWhen(
                Mono.just(this.getReactiveLockExecutor()),
                reactiveLockExecutor -> reactiveLockExecutor.obtain()
                        .filter(result -> result)
                        .repeatWhenEmpty(Repeat.<T>onlyIf(repeatContext -> true)
                                .timeout(lockExpireTime)
                                .fixedBackoff(Duration.ofMillis(100))
                                .doOnRepeat(objectRepeatContext -> {
                                    if (log.isTraceEnabled()) {
                                        log.trace("[Mono ExecutionRepeat Acquire Lock Repeat Content:{}", objectRepeatContext);
                                    }
                                })
                        )
                        .defaultIfEmpty(false)
                        .doOnNext(lockResult -> log.info("[Mono ExecutionTry lock,LockResult:{}", lockResult))
                        .flatMap(lockResultExecution),
                reactiveLockExecutor -> reactiveLockExecutor.release()
                        .doOnNext(releaseResult -> log.info("[Mono Execution(Normal Release) ReleaseResult:{}", releaseResult)),
                (reactiveLockExecutor, err) -> reactiveLockExecutor.release()
                        .doOnNext(releaseResult -> log.info("[Mono Execution(When ERROR Release)ReleaseResult:{}", releaseResult)),
                reactiveLockExecutor -> reactiveLockExecutor.release()
                        .doOnNext(releaseResult -> log.info("[Mono Execution(When AsyncCancel Release),ReleaseResult:{}", releaseResult))
        );
    }
}
