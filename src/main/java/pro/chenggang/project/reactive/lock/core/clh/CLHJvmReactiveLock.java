package pro.chenggang.project.reactive.lock.core.clh;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pro.chenggang.project.reactive.lock.core.StatefulReactiveLock;
import pro.chenggang.project.reactive.lock.util.IdUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.retry.Repeat;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;

/**
 * Jvm reactive lock based on CLH algorithm
 *
 * @author Gang Cheng
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
public class CLHJvmReactiveLock implements StatefulReactiveLock {

    private static final AtomicReferenceFieldUpdater<CLHJvmReactiveLock, CLHNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(CLHJvmReactiveLock.class, CLHNode.class, "tail");
    private final AtomicLong lockAt = new AtomicLong(-1);
    private final AtomicBoolean isInProgress = new AtomicBoolean(false);
    private final AtomicReference<String> currentLockId = new AtomicReference<>();
    private volatile CLHNode tail;

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

    @Override
    public long latestLockTime() {
        return this.lockAt.getAcquire();
    }

    @Override
    public Mono<Boolean> isInProcess() {
        return Mono.just(this.isInProgress.getAcquire() || Objects.nonNull(tail));
    }

    @Override
    public String toString() {
        return "CLHJvmReactiveLock{" +
                "currentLockId=" + currentLockId.get() +
                ", lockAt=" + lockAt +
                ", isInProgress=" + isInProgress +
                '}';
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
                    Mono.just(new CLHNode()),
                    clhNode -> Mono.justOrEmpty(UPDATER.getAndSet(this, clhNode))
                            .map(preNode -> {
                                boolean lockSuccess = !preNode.isLocked;
                                if (lockSuccess) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    clhNode.lockAt = currentTimeMillis;
                                    lockAt.getAndSet(currentTimeMillis);
                                    isInProgress.getAndSet(true);
                                    currentLockId.getAndSet(clhNode.nodeId);
                                }
                                return lockSuccess;
                            })
                            .defaultIfEmpty(true)
                            .doOnNext(lockResult -> log.info("[Mono Execution]Try lock [{}],LockResult:{}", clhNode.nodeId, lockResult))
                            .flatMap(lockResultExecution),
                    clhNode -> this.releaseCLHNode(clhNode)
                            .doOnNext(releaseResult -> log.info("[Mono Execution](Normal Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult)),
                    (clhNode, err) -> this.releaseCLHNode(clhNode)
                            .doOnNext(releaseResult -> log.info("[Mono Execution](When ERROR Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult)),
                    clhNode -> this.releaseCLHNode(clhNode)
                            .doOnNext(releaseResult -> log.info("[Mono Execution](When AsyncCancel Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult))
            );
        }
        return Mono.usingWhen(
                Mono.just(new CLHNode()),
                clhNode -> Mono.justOrEmpty(UPDATER.getAndSet(this, clhNode))
                        .map(preNode -> {
                            boolean lockSuccess = !preNode.isLocked;
                            if (lockSuccess) {
                                long currentTimeMillis = System.currentTimeMillis();
                                clhNode.lockAt = currentTimeMillis;
                                lockAt.getAndSet(currentTimeMillis);
                                isInProgress.getAndSet(true);
                            }
                            return lockSuccess;
                        })
                        .defaultIfEmpty(true)
                        .filter(result -> result)
                        .repeatWhenEmpty(Repeat.<T>onlyIf(repeatContext -> true)
                                .timeout(lockExpireTime)
                                .fixedBackoff(Duration.ofMillis(100))
                                .doOnRepeat(objectRepeatContext -> {
                                    if (log.isTraceEnabled()) {
                                        log.trace("[Mono Execution]Repeat Acquire Lock Repeat Content:{}", objectRepeatContext);
                                    }
                                })
                        )
                        .defaultIfEmpty(false)
                        .doOnNext(lockResult -> log.info("[Mono Execution]Try lock [{}],LockResult:{}", clhNode.nodeId, lockResult))
                        .flatMap(lockResultExecution),
                clhNode -> this.releaseCLHNode(clhNode)
                        .doOnNext(releaseResult -> log.info("[Mono Execution](Normal Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult)),
                (clhNode, err) -> this.releaseCLHNode(clhNode)
                        .doOnNext(releaseResult -> log.info("[Mono Execution](When ERROR Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult)),
                clhNode -> this.releaseCLHNode(clhNode)
                        .doOnNext(releaseResult -> log.info("[Mono Execution](When AsyncCancel Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult))
        );
    }

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
                    Mono.just(new CLHNode()),
                    clhNode -> Mono.justOrEmpty(UPDATER.getAndSet(this, clhNode))
                            .map(preNode -> {
                                boolean lockSuccess = !preNode.isLocked;
                                if (lockSuccess) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    clhNode.lockAt = currentTimeMillis;
                                    lockAt.getAndSet(currentTimeMillis);
                                    isInProgress.getAndSet(true);
                                    currentLockId.getAndSet(clhNode.nodeId);
                                }
                                return lockSuccess;
                            })
                            .defaultIfEmpty(true)
                            .doOnNext(lockResult -> log.info("[Flux Execution]Try lock [{}],LockResult:{}", clhNode.nodeId, lockResult))
                            .flatMapMany(lockResultExecution),
                    clhNode -> this.releaseCLHNode(clhNode)
                            .doOnNext(releaseResult -> log.info("[Flux Execution](Normal Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult)),
                    (clhNode, err) -> this.releaseCLHNode(clhNode)
                            .doOnNext(releaseResult -> log.info("[Flux Execution](When ERROR Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult)),
                    clhNode -> this.releaseCLHNode(clhNode)
                            .doOnNext(releaseResult -> log.info("[Flux Execution](When AsyncCancel Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult))
            );
        }
        return Flux.usingWhen(
                Mono.just(new CLHNode()),
                clhNode -> Mono.justOrEmpty(UPDATER.getAndSet(this, clhNode))
                        .map(preNode -> {
                            boolean lockSuccess = !preNode.isLocked;
                            if (lockSuccess) {
                                long currentTimeMillis = System.currentTimeMillis();
                                clhNode.lockAt = currentTimeMillis;
                                lockAt.getAndSet(currentTimeMillis);
                                isInProgress.getAndSet(true);
                                currentLockId.getAndSet(clhNode.nodeId);
                            }
                            return lockSuccess;
                        })
                        .defaultIfEmpty(true)
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
                        .doOnNext(lockResult -> log.info("[Flux Execution]Try lock[{}],LockResult:{}", clhNode.nodeId, lockResult))
                        .flatMapMany(lockResultExecution),
                clhNode -> this.releaseCLHNode(clhNode)
                        .doOnNext(releaseResult -> log.info("[Flux Execution](Normal Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult)),
                (clhNode, err) -> this.releaseCLHNode(clhNode)
                        .doOnNext(releaseResult -> log.info("[Flux Execution](When ERROR Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult)),
                clhNode -> this.releaseCLHNode(clhNode)
                        .doOnNext(releaseResult -> log.info("[Flux Execution](When AsyncCancel Release)[{}],ReleaseResult:{}", clhNode.nodeId, releaseResult))
        );
    }

    /**
     * release CLHNode
     *
     * @param clhNode CLHNode
     * @return release result
     */
    private Mono<Boolean> releaseCLHNode(CLHNode clhNode) {
        if (!clhNode.isLocked) {
            return Mono.just(true);
        }
        boolean releaseResult = false;
        if (!UPDATER.compareAndSet(this, clhNode, null)) {
            releaseResult = true;
            clhNode.isLocked = false;
            lockAt.getAndSet(-1);
            isInProgress.getAndSet(false);
        }
        return Mono.just(releaseResult);
    }

    /**
     * CLH Node
     */
    @ToString
    private static class CLHNode {
        private final String nodeId = IdUtil.getInstance().generateId();
        private volatile boolean isLocked = true;
        private volatile long lockAt;
    }

}
