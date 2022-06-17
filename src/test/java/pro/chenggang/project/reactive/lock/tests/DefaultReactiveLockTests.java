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
import static pro.chenggang.project.reactive.lock.tests.ProcessFunctions.FAILED;
import static pro.chenggang.project.reactive.lock.tests.ProcessFunctions.OK;

/**
 * @author Gang Cheng
 * @date 2021-03-14.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = ReactiveLockApplication.class)
public class DefaultReactiveLockTests {

    @Qualifier("defaultReactiveLockRegistry")
    @Autowired
    private ReactiveLockRegistry defaultReactiveLockRegistry;

    @BeforeTestClass
    public void init(){
        Hooks.onOperatorDebug();
        BlockHound.install();
    }

    @Test
    public void testLoadConfiguration() throws Exception {
        assertNotNull(defaultReactiveLockRegistry);
    }

    @Test
    public void testAcquireOnce() throws Exception {
        ProcessFunctions processFunctions = new ProcessFunctions();
        Flux<String> flux = Flux.range(0, 5)
                .flatMap(value -> this.defaultReactiveLockRegistry.obtain()
                        .tryLockThenExecute(
                                lockResult -> {
                                    if(!lockResult){
                                        return Mono.just(FAILED);
                                    }
                                    return processFunctions.processFunction();
                                }
                        )
                )
                .doOnNext(System.out::println);
        StepVerifier.create(flux)
                .expectNext(OK)
                .expectNext(OK)
                .expectNext(OK)
                .expectNext(OK)
                .expectNext(OK)
                .verifyComplete();

    }

    @Test
    public void testAcquireDurationWithinExpireTime() throws Exception {
        //default lock expire is 10S
        ProcessFunctions processFunctions = new ProcessFunctions();
        Flux<String> flux = Flux.range(0, 3)
                .flatMap(value -> this.defaultReactiveLockRegistry.obtain()
                        .lockThenExecute(
                                Duration.ofSeconds(10),
                                lockResult -> {
                                    if(!lockResult){
                                        return Mono.just(FAILED);
                                    }
                                    return processFunctions.processDelayFunction(Duration.ofSeconds(2));
                                }
                        )
                );
        StepVerifier.create(flux)
                .expectNext(OK)
                .expectNext(OK)
                .expectNext(OK)
                .verifyComplete();

    }

    @Test
    public void testAcquireDurationOutOfExpireTime() throws Exception {
        ProcessFunctions processFunctions = new ProcessFunctions();
        Flux<String> flux = Flux.range(0, 3)
                .subscribeOn(Schedulers.parallel())
                .flatMap(value -> this.defaultReactiveLockRegistry.obtain()
                        .lockThenExecute(
                                Duration.ofSeconds(3),
                                lockResult -> {
                                    if (!lockResult) {
                                        System.out.println("Lock Error");
                                        return Mono.just(FAILED);
                                    }
                                    return processFunctions.processDelayFunction(Duration.ofSeconds(2));
                                }
                        )
                );
        StepVerifier.create(flux)
                .expectNext(OK)
                .expectNext(FAILED)
                .expectNext(OK)
                .verifyComplete();
    }

}
