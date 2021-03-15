package pro.chenggang.project.reactive.redis.distributedlock.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import pro.chenggang.project.reactive.redis.distributedlock.ReactiveRedisDistributedLockApplication;
import pro.chenggang.project.reactive.redis.distributedlock.core.ReactiveRedisDistributedLockRegistry;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static pro.chenggang.project.reactive.redis.distributedlock.tests.ReactiveTests.ProcessFunctions.FAILED;
import static pro.chenggang.project.reactive.redis.distributedlock.tests.ReactiveTests.ProcessFunctions.OK;

/**
 * @author: chenggang
 * @date 2021-03-14.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ReactiveRedisDistributedLockApplication.class)
public class ReactiveTests {

    @Autowired
    private ReactiveRedisDistributedLockRegistry reactiveRedisDistributedLockRegistry;

    @BeforeTestClass
    public void init(){
        Hooks.onOperatorDebug();
    }

    @Test
    public void testLoadConfiguration() throws Exception {
        assertNotNull(reactiveRedisDistributedLockRegistry);
    }

    @Test
    public void testAcquireOnce() throws Exception {
        ProcessFunctions processFunctions = new ProcessFunctions();
        String key = "LOCK_ONCE";
        Flux<String> flux = Flux.range(0, 5)
                .flatMap(value -> this.reactiveRedisDistributedLockRegistry.obtain(key)
                        .acquireOnce()
                        .filter(acquireResult -> acquireResult)
                        .flatMap(acquireResult -> processFunctions.processFunction())
                        .switchIfEmpty(Mono.just(FAILED))
                )
                .doOnNext(System.out::println);
        StepVerifier.create(flux)
                .expectNext(OK)
                .expectNext(FAILED)
                .expectNext(FAILED)
                .expectNext(FAILED)
                .expectNext(FAILED)
                .verifyComplete();

    }

    @Test
    public void testAcquireDefaultDurationAndProcessDuringTheExpireDuration() throws Exception {
        //default lock expire is 10S
        ProcessFunctions processFunctions = new ProcessFunctions();
        String key = "LOCK_DEFAULT";
        Flux<String> flux = Flux.range(0, 3)
                .flatMap(value -> this.reactiveRedisDistributedLockRegistry.obtain(key)
                        .acquireAndExecute(() ->
                                processFunctions.processDelayFunction(Duration.ofSeconds(2))
                        )
                        .doOnNext(System.out::println)
                        .onErrorResume(throwable -> CannotAcquireLockException.class.isAssignableFrom(throwable.getClass()),throwable -> {
                            System.out.println("Lock Error");
                            return Mono.just(FAILED);
                        })
                );
        StepVerifier.create(flux)
                .expectNext(OK)
                .expectNext(OK)
                .expectNext(OK)
                .verifyComplete();

    }

    @Test
    public void testAcquireDuration() throws Exception {
        ProcessFunctions processFunctions = new ProcessFunctions();
        String key = "LOCK_GIVEN_DURATION";
        Flux<String> flux = Flux.range(0, 3)
                .subscribeOn(Schedulers.parallel())
                .flatMap(value -> this.reactiveRedisDistributedLockRegistry.obtain(key)
                        .acquireAndExecute(Duration.ofSeconds(3), () ->
                                processFunctions.processDelayFunction(Duration.ofSeconds(2))
                        )
                        .doOnNext(System.out::println)
                        .onErrorResume(throwable -> CannotAcquireLockException.class.isAssignableFrom(throwable.getClass()), throwable -> {
                            System.out.println("Lock Error");
                            return Mono.just(FAILED);
                        })
                );
        StepVerifier.create(flux)
                .expectNext(OK)
                .expectNext(FAILED)
                .expectNext(OK)
                .verifyComplete();

    }

    class ProcessFunctions {

        static final String OK = "OK";
        static final String FAILED = "FAILED";

        Mono<String> processDelayFunction(Duration delayDuration){
            return Mono.just(OK).delayElement(delayDuration);
        }

        Mono<String> processFunction(){
            return Mono.just(OK);
        }
    }
}
