# reactive-lock
Reactive Lock Demo

### Use Case

* 1 . Make Sure Use Spring Boot Starter Dependency if using `redis-reactive-lock`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
</dependency>
```

* 2 . Configure Properties


```yaml
lock:
  reactive:
    expire-after: 10s
    expire-evict-idle: 1s
    type:
      - DEFAULT   # default using simple spin lock
      - REDIS    # redis
      - CLH     # jvm lock using CLH algorithm
      - MCS     # jvm lock using MCS algorithm
```

* 3 . Autowired By Spring
  * `ReactiveLockRegistry defaultReactiveLockRegistry` 
  * `ReactiveLockRegistry redisReactiveLockRegistry` 
  * `ReactiveLockRegistry clhReactiveLockRegistry`
  * `ReactiveLockRegistry mcsReactiveLockRegistry`

* 4 . Use `ReactiveLockRegistry` With Your Reactive Application

```java
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
```

* 5 .If You Need More Detail About This Please Read The Source Code and test cases.

# Reference

* RedisLockRegistry: https://docs.spring.io/spring-integration/docs/5.3.6.RELEASE/reference/html/redis.html#redis-lock-registry
* Trigger Mono Execution After Another Mono Terminates: https://stackoverflow.com/questions/50686524/how-to-trigger-mono-execution-after-another-mono-terminates

# Benchmark Results

> Benchmark details is in `benchmark` folder

> To display benchmark results ,recommending using this website [jmh.morethan.io](https://jmh.morethan.io/)