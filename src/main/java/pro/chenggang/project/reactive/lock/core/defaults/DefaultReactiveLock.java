package pro.chenggang.project.reactive.lock.core.defaults;

import lombok.extern.slf4j.Slf4j;
import pro.chenggang.project.reactive.lock.core.ReactiveLockExecutor;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * The Default reactive lock.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
@Slf4j
public class DefaultReactiveLock extends AbstractReactiveLock {

    private final AtomicBoolean lockSignal = new AtomicBoolean(false);
    private final ReactiveLockExecutor defaultJvmReactiveLockExecutor = new DefaultJvmReactiveLockExecutor();

    @Override
    protected ReactiveLockExecutor getReactiveLockExecutor() {
        return defaultJvmReactiveLockExecutor;
    }

    @Override
    public long latestLockTime() {
        return defaultJvmReactiveLockExecutor.lockAt();
    }

    @Override
    public Mono<Boolean> isInProcess() {
        return defaultJvmReactiveLockExecutor.isInProcess();
    }

    @Override
    public String toString() {
        return "DefaultReactiveLock{" +
                "lockSignal=" + lockSignal +
                ",lockedAt=" + defaultJvmReactiveLockExecutor.lockAt() +
                '}';
    }

    private class DefaultJvmReactiveLockExecutor implements ReactiveLockExecutor {

        private volatile long lockedAt;

        @Override
        public long lockAt() {
            return this.lockedAt;
        }

        @Override
        public Mono<Boolean> isInProcess() {
            return Mono.just(DefaultReactiveLock.this.lockSignal.getAcquire());
        }

        @Override
        public Mono<Boolean> obtain() {
            return Mono.fromSupplier(() -> DefaultReactiveLock.this.lockSignal.compareAndSet(false, true))
                    .map(success -> {
                        boolean result = Boolean.TRUE.equals(success);
                        if (result) {
                            this.lockedAt = System.currentTimeMillis();
                        }
                        return result;
                    });
        }

        @Override
        public Mono<Boolean> release() {
            return Mono.fromSupplier(() -> DefaultReactiveLock.this.lockSignal.compareAndSet(true, false));
        }

    }

}
