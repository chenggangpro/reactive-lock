package pro.chenggang.project.reactive.lock.core.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import pro.chenggang.project.reactive.lock.core.ReactiveLock;
import pro.chenggang.project.reactive.lock.core.ReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.core.StatefulReactiveLock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The Abstract auto cleanup reactive lock registry.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
@Slf4j
public abstract class AbstractAutoCleanupReactiveLockRegistry implements ReactiveLockRegistry, InitializingBean, DisposableBean {

    /**
     * The constant DEFAULT_EXPIRE_EVICT_IDLE.
     */
    protected static final Duration DEFAULT_EXPIRE_EVICT_IDLE = Duration.ofMinutes(3);
    /**
     * The constant DEFAULT_MAX_LOCK_LIFETIME.
     */
    protected static final Duration DEFAULT_MAX_LOCK_LIFETIME = Duration.ofMinutes(10);
    private final Scheduler scheduler = Schedulers.newSingle("redis-lock-evict", true);
    private final Map<String, StatefulReactiveLock> lockRegistry = new ConcurrentHashMap<>();
    private final Duration expireEvictIdle;
    private final Duration maxLockLifeTime;

    /**
     * Instantiates a new Abstract auto cleanup reactive lock registry.
     *
     * @param expireEvictIdle the expire evict idle
     * @param maxLockLifeTime the max lock life time
     */
    public AbstractAutoCleanupReactiveLockRegistry(Duration expireEvictIdle, Duration maxLockLifeTime) {
        this.expireEvictIdle = expireEvictIdle;
        this.maxLockLifeTime = maxLockLifeTime;
    }

    /**
     * new reactive lock
     *
     * @param lockKey the lock key
     * @return stateful reactive lock
     */
    protected abstract StatefulReactiveLock newReactiveLock(String lockKey);

    @Override
    public ReactiveLock obtain(String lockKey) {
        ReactiveLock reactiveLock = lockRegistry.get(lockKey);
        if (reactiveLock != null) {
            return reactiveLock;
        }
        return lockRegistry.computeIfAbsent(lockKey, this::newReactiveLock);
    }

    @Override
    public void afterPropertiesSet() {
        String classSimpleName = this.getClass().getSimpleName();
        log.debug("Initialize Auto Remove Unused Lock Execution :{}", classSimpleName);
        Flux.interval(expireEvictIdle, scheduler)
                .flatMap(value -> {
                    long now = System.currentTimeMillis();
                    if (log.isTraceEnabled()) {
                        log.trace("Auto Remove Unused Lock [{}],Evict Triggered", classSimpleName);
                    }
                    return Flux.fromIterable(this.lockRegistry.entrySet())
                            .filter(entry -> now - entry.getValue().latestLockTime() > maxLockLifeTime.toMillis())
                            .flatMap(entry -> entry.getValue()
                                    .isInProcess()
                                    .filter(inProcess -> !inProcess)
                                    .doOnNext(inProcess -> {
                                        this.lockRegistry.remove(entry.getKey());
                                        log.debug("Auto Remove Unused Lock[{}],Lock Info:{}", classSimpleName, entry);
                                    })
                                    .onErrorResume(throwable -> {
                                        log.error("Auto Remove Unused Locks[{}],Occur Exception,Lock Info: {}", classSimpleName, entry, throwable);
                                        return Mono.empty();
                                    })
                            );
                })
                .subscribe();
    }

    @Override
    public void destroy() {
        if (!this.scheduler.isDisposed()) {
            log.debug("Shutdown Auto Remove Unused Lock Execution :{}", this.getClass().getSimpleName());
            this.scheduler.dispose();
        }
    }
}
