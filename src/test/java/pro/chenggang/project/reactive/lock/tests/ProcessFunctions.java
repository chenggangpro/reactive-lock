package pro.chenggang.project.reactive.lock.tests;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ProcessFunctions {

    public static final String OK = "OK";
    public static final String FAILED = "FAILED";

    public Mono<String> processDelayFunction(Duration delayDuration) {
        return Mono.just(OK).delayElement(delayDuration);
    }

    public Mono<String> processFunction() {
        return Mono.just(OK);
    }

    public Flux<String> processDelayFluxFunction(Duration delayDuration) {
        return Flux
                .range(0, 10)
                .flatMap(value -> Mono.just(OK))
                .delayElements(delayDuration);
    }

    public Flux<String> processFluxFunction() {
        return Flux
                .range(0, 3)
                .flatMap(value -> Mono.just(OK));
    }
}