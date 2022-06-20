package pro.chenggang.project.reactive.lock.core.mcs;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pro.chenggang.project.reactive.lock.core.StatefulReactiveLock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.retry.Repeat;

import java.time.Duration;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;

/**
 * Jvm reactive lock based on MCS algorithm
 *
 * @author Gang Cheng
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
public class MCSJvmReactiveLock implements StatefulReactiveLock {

    private static final AtomicReferenceFieldUpdater<MCSJvmReactiveLock, MCSNode> UPDATER =
            AtomicReferenceFieldUpdater.newUpdater(MCSJvmReactiveLock.class, MCSNode.class, "queue");
    private final AtomicLong lockAt = new AtomicLong(-1);
    private final AtomicBoolean isInProgress = new AtomicBoolean(false);
    private final AtomicReference<String> currentLockId = new AtomicReference<>();
    private volatile MCSNode queue;

    @Override
    public <T> Mono<T> tryLockThenExecute(@NotNull Function<Boolean, Mono<T>> lockResultExecution) {
        return this.executeWithMono(null, lockResultExecution);
    }

    @Override
    public <T> Flux<T> tryLockThenExecuteMany(@NotNull Function<Boolean, Flux<T>> lockResultExecution) {
        return this.executeWithFlux(null,lockResultExecution);
    }

    @Override
    public <T> Mono<T> lockThenExecute(@NotNull Duration duration, @NotNull Function<Boolean, Mono<T>> lockResultExecution) {
        return this.executeWithMono(duration, lockResultExecution);
    }

    @Override
    public <T> Flux<T> lockThenExecuteMany(@NotNull Duration duration, @NotNull Function<Boolean, Flux<T>> lockResultExecution) {
        return this.executeWithFlux(duration,lockResultExecution);
    }

    @Override
    public long latestLockTime() {
        return this.lockAt.getAcquire();
    }

    @Override
    public Mono<Boolean> isInProcess() {
        return Mono.just(this.isInProgress.getAcquire() || Objects.nonNull(queue));
    }

    @Override
    public String toString() {
        return "MCSJvmReactiveLock{" +
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
                    Mono.just(new MCSNode()),
                    mcsNode -> Mono.justOrEmpty(UPDATER.getAndSet(this, mcsNode))
                            .map(preNode -> {
                                preNode.next = mcsNode;
                                boolean lockSuccess = !mcsNode.isLocked;
                                if (lockSuccess) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    mcsNode.lockAt = currentTimeMillis;
                                    lockAt.getAndSet(currentTimeMillis);
                                    isInProgress.getAndSet(true);
                                    currentLockId.getAndSet(mcsNode.nodeId);
                                }
                                return lockSuccess;
                            })
                            .defaultIfEmpty(true)
                            .doOnNext(lockResult -> log.info("[Mono Execution]Try lock [{}],LockResult:{}", mcsNode.nodeId, lockResult))
                            .flatMap(lockResultExecution),
                    mcsNode -> this.releaseMCSNode(mcsNode)
                            .doOnNext(releaseResult -> log.info("[Mono Execution](Normal Release) [{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult)),
                    (mcsNode, err) -> this.releaseMCSNode(mcsNode)
                            .doOnNext(releaseResult -> log.info("[Mono Execution](When ERROR Release) [{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult)),
                    mcsNode -> this.releaseMCSNode(mcsNode)
                            .doOnNext(releaseResult -> log.info("[Mono Execution](When AsyncCancel Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult))
            );
        }
        return Mono.usingWhen(
                Mono.just(new MCSNode()),
                mcsNode -> Mono.justOrEmpty(UPDATER.getAndSet(this, mcsNode))
                        .map(preNode -> {
                            preNode.next = mcsNode;
                            boolean lockSuccess = !mcsNode.isLocked;
                            if (lockSuccess) {
                                long currentTimeMillis = System.currentTimeMillis();
                                mcsNode.lockAt = currentTimeMillis;
                                lockAt.getAndSet(currentTimeMillis);
                                isInProgress.getAndSet(true);
                                currentLockId.getAndSet(mcsNode.nodeId);
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
                                        log.trace("[Mono Execution]Repeat Acquire Lock,Repeat Content:{}", objectRepeatContext);
                                    }
                                })
                        )
                        .defaultIfEmpty(false)
                        .doOnNext(lockResult -> log.info("[Mono Execution]Try lock [{}],LockResult:{}", mcsNode.nodeId, lockResult))
                        .flatMap(lockResultExecution),
                mcsNode -> this.releaseMCSNode(mcsNode)
                        .doOnNext(releaseResult -> log.info("[Mono Execution](Normal Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult)),
                (mcsNode, err) -> this.releaseMCSNode(mcsNode)
                        .doOnNext(releaseResult -> log.info("[Mono Execution](When ERROR Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult)),
                mcsNode -> this.releaseMCSNode(mcsNode)
                        .doOnNext(releaseResult -> log.info("[Mono Execution](When AsyncCancel Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult))
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
                    Mono.just(new MCSNode()),
                    mcsNode -> Mono.justOrEmpty(UPDATER.getAndSet(this, mcsNode))
                            .map(preNode -> {
                                preNode.next = mcsNode;
                                boolean lockSuccess = !mcsNode.isLocked;
                                if (lockSuccess) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    mcsNode.lockAt = currentTimeMillis;
                                    lockAt.getAndSet(currentTimeMillis);
                                    isInProgress.getAndSet(true);
                                    currentLockId.getAndSet(mcsNode.nodeId);
                                }
                                return lockSuccess;
                            })
                            .defaultIfEmpty(true)
                            .doOnNext(lockResult -> log.info("[Flux Execution]Try lock [{}],LockResult:{}", mcsNode.nodeId, lockResult))
                            .flatMapMany(lockResultExecution),
                    mcsNode -> this.releaseMCSNode(mcsNode)
                            .doOnNext(releaseResult -> log.info("[Flux Execution](Normal Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult)),
                    (mcsNode, err) -> this.releaseMCSNode(mcsNode)
                            .doOnNext(releaseResult -> log.info("[Flux Execution](When ERROR Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult)),
                    mcsNode -> this.releaseMCSNode(mcsNode)
                            .doOnNext(releaseResult -> log.info("[Flux Execution](When AsyncCancel Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult))
            );
        }
        return Flux.usingWhen(
                Mono.just(new MCSNode()),
                mcsNode -> Mono.justOrEmpty(UPDATER.getAndSet(this, mcsNode))
                        .map(preNode -> {
                            preNode.next = mcsNode;
                            boolean lockSuccess = !mcsNode.isLocked;
                            if (lockSuccess) {
                                long currentTimeMillis = System.currentTimeMillis();
                                mcsNode.lockAt = currentTimeMillis;
                                lockAt.getAndSet(currentTimeMillis);
                                isInProgress.getAndSet(true);
                                currentLockId.getAndSet(mcsNode.nodeId);
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
                                        log.trace("[Flux Execution]Repeat Acquire Lock,Repeat Content:{}", objectRepeatContext);
                                    }
                                })
                        )
                        .defaultIfEmpty(false)
                        .doOnNext(lockResult -> log.info("[Flux Execution]Try lock[{}],LockResult:{}", mcsNode.nodeId, lockResult))
                        .flatMapMany(lockResultExecution),
                mcsNode -> this.releaseMCSNode(mcsNode)
                        .doOnNext(releaseResult -> log.info("[Flux Execution](Normal Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult)),
                (mcsNode, err) -> this.releaseMCSNode(mcsNode)
                        .doOnNext(releaseResult -> log.info("[Flux Execution](When ERROR Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult)),
                mcsNode -> this.releaseMCSNode(mcsNode)
                        .doOnNext(releaseResult -> log.info("[Flux Execution](When AsyncCancel Release)[{}],ReleaseResult:{}", mcsNode.nodeId, releaseResult))
        );
    }

    /**
     * release MCSNode
     *
     * @param mcsNode MCSNode
     * @return release result
     */
    private Mono<Boolean> releaseMCSNode(MCSNode mcsNode) {
        // if node has been released already
        if(mcsNode.getAcquire()){
            return Mono.just(true);
        }
        mcsNode.compareAndSet(false,true);
        return Mono.just(mcsNode)
                .filter(currentNode -> Objects.isNull(currentNode.next))
                .flatMap(currentNode -> {
                    if (UPDATER.compareAndSet(this, currentNode, null)) {
                        return Mono.just(true);
                    }
                    return Mono.fromSupplier(() -> currentNode.next)
                            .repeatWhenEmpty(Repeat.<MCSNode>onlyIf(repeatContext -> true)
                                    .fixedBackoff(Duration.ofMillis(100))
                                    .doOnRepeat(objectRepeatContext -> {
                                        if (log.isTraceEnabled()) {
                                            log.trace("[Release MCS Execution]Repeat Release Lock,Repeat Content:{}", objectRepeatContext);
                                        }
                                    })
                            )
                            .map(nextNode -> true);
                })
                .switchIfEmpty(Mono.defer(() -> {
                    mcsNode.next.isLocked = false;
                    mcsNode.next = null;
                    return Mono.just(true);
                }));
    }

    /**
     * MCS Node
     * in case of reactor's usingWhen() release node more than once
     */
    @ToString
    private static class MCSNode extends AtomicBoolean{

        private static final long serialVersionUID = -4741467022303970726L;

        private final String nodeId = UUID.randomUUID().toString();
        private volatile MCSNode next;
        private volatile boolean isLocked = true;
        private volatile long lockAt;
    }

}
