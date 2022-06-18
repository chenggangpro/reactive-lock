package pro.chenggang.project.reactive.lock.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import pro.chenggang.project.reactive.lock.ReactiveLockApplication;
import pro.chenggang.project.reactive.lock.core.ReactiveLockRegistry;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Gang Cheng
 * @date 2021-03-14.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ReactiveLockApplication.class)
public class RedisReactiveLockTests {

    @Qualifier("redisReactiveLockRegistry")
    @Autowired
    private ReactiveLockRegistry redisReactiveLockRegistry;

    @BeforeTestClass
    public void init(){
        System.setProperty("io.netty.leakDetection.level","PARANOID");
        Hooks.onOperatorDebug();
        BlockHound.install();
    }

    @Test
    public void testLoadConfiguration() throws Exception {
        assertNotNull(redisReactiveLockRegistry);
    }

    @Test
    public void testAcquireOnce() throws Exception {
        ProcessFunctions processFunctions = new ProcessFunctions();
        String lockKey = "LOCK_ONCE";
        Flux<String> flux = Flux.range(0, 5)
                .flatMapSequential(value -> this.redisReactiveLockRegistry.obtain(lockKey)
                        .tryLockThenExecute(
                                lockResult -> {
                                    if(!lockResult){
                                        return Mono.just(ProcessFunctions.FAILED);
                                    }
                                    return processFunctions.processFunction();
                                }
                        )
                )
                .doOnNext(System.out::println);
        StepVerifier.create(flux)
                .expectNext(ProcessFunctions.OK)
                .expectNext(ProcessFunctions.FAILED)
                .expectNext(ProcessFunctions.FAILED)
                .expectNext(ProcessFunctions.FAILED)
                .expectNext(ProcessFunctions.FAILED)
                .verifyComplete();

    }

    @Test
    public void testAcquireOnceOrdered() throws Exception {
        ProcessFunctions processFunctions = new ProcessFunctions();
        String lockKey = "LOCK_ONCE";
        Flux<String> flux = Flux.range(0, 5)
                .concatMap(value -> this.redisReactiveLockRegistry.obtain(lockKey)
                        .tryLockThenExecute(
                                lockResult -> {
                                    if(!lockResult){
                                        return Mono.just(ProcessFunctions.FAILED);
                                    }
                                    return processFunctions.processFunction();
                                }
                        )
                )
                .doOnNext(System.out::println);
        StepVerifier.create(flux)
                .expectNext(ProcessFunctions.OK)
                .expectNext(ProcessFunctions.OK)
                .expectNext(ProcessFunctions.OK)
                .expectNext(ProcessFunctions.OK)
                .expectNext(ProcessFunctions.OK)
                .verifyComplete();

    }

    @Test
    public void testAcquireDurationWithinExpireTime() throws Exception {
        //default lock expire is 10S
        String lockKey = "LOCK_WITHIN_EXPIRE_TIME";
        ProcessFunctions processFunctions = new ProcessFunctions();
        Flux<String> flux = Flux.range(0, 10000)
                .flatMap(value -> this.redisReactiveLockRegistry.obtain(lockKey)
                        .lockThenExecute(
                                Duration.ofSeconds(10),
                                lockResult -> {
                                    if(!lockResult){
                                        return Mono.just(ProcessFunctions.FAILED);
                                    }
                                    return processFunctions.processDelayFunction(Duration.ofSeconds(2));
                                }
                        )
                );
        flux.blockLast();

    }

    @Test
    public void testAcquireDurationOutOfExpireTime() throws Exception {
        String lockKey = "LOCK_OUT_OF_EXPIRE_TIME";
        ProcessFunctions processFunctions = new ProcessFunctions();
        Flux<String> flux = Flux.range(0, 3)
                .subscribeOn(Schedulers.parallel())
                .flatMap(value -> this.redisReactiveLockRegistry.obtain(lockKey)
                        .lockThenExecute(
                                Duration.ofSeconds(3),
                                lockResult -> {
                                    if (!lockResult) {
                                        System.out.println("Lock Error");
                                        return Mono.just(ProcessFunctions.FAILED);
                                    }
                                    return processFunctions.processDelayFunction(Duration.ofSeconds(2));
                                }
                        )
                );
        StepVerifier.create(flux)
                .expectNext(ProcessFunctions.OK)
                .expectNext(ProcessFunctions.FAILED)
                .expectNext(ProcessFunctions.OK)
                .verifyComplete();
    }

}
