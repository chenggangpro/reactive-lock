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
    reactive-lock-type:
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

> ```txt
> # Detecting actual CPU count: 8 detected
> # JMH version: 1.34
> # VM version: JDK 11.0.10, OpenJDK 64-Bit Server VM, 11.0.10+9
> # VM options: -Xmx4G -Xms4G -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled
> # Warmup: 1 iterations, 5 s each
> # Measurement: 5 iterations, 10 s each
> # Timeout: 10 min per iteration
> # Threads: 8 threads, will synchronize iterations
> ```

> ```txt
> REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
> why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
> experiments, perform baseline and negative tests that provide experimental control, make sure
> the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
> Do not assume the numbers tell you what you want them to tell.
> ```
> 

#### DefaultReactiveLock

> See `pro.chenggang.project.reactive.lock.benchmark.DefaultReactiveLockBenchmarkTests`

* Throughput

```txt
Benchmark                                     Mode  Cnt        Score       Error  Units
DefaultReactiveLockBenchmark.testLockExpire  thrpt   25    69484.373 ± 10690.659  ops/s
DefaultReactiveLockBenchmark.testTryLock     thrpt   25  1350325.303 ± 70065.971  ops/s
```

* Sample Time

```txt
Benchmark                                                             Mode       Cnt           Score       Error  Units
DefaultReactiveLockBenchmark.testLockExpire                         sample  19995332      104168.645 ± 11120.767  ns/op
DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.00    sample                  2192.000              ns/op
DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.50    sample                  4248.000              ns/op
DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.90    sample                 10224.000              ns/op
DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.95    sample                 55872.000              ns/op
DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.99    sample                324096.000              ns/op
DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.999   sample               1660928.000              ns/op
DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p0.9999  sample               8380416.000              ns/op
DefaultReactiveLockBenchmark.testLockExpire:testLockExpire·p1.00    sample            3535798272.000              ns/op
DefaultReactiveLockBenchmark.testTryLock                            sample  41830912       11815.775 ±  1398.239  ns/op
DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.00          sample                   532.000              ns/op
DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.50          sample                  1288.000              ns/op
DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.90          sample                  1572.000              ns/op
DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.95          sample                  1666.000              ns/op
DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.99          sample                  7480.000              ns/op
DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.999         sample                268288.000              ns/op
DefaultReactiveLockBenchmark.testTryLock:testTryLock·p0.9999        sample               7503872.000              ns/op
DefaultReactiveLockBenchmark.testTryLock:testTryLock·p1.00          sample            2734686208.000              ns/op
```

* Average Time

```txt
Benchmark                                    Mode  Cnt       Score       Error  Units
DefaultReactiveLockBenchmark.testLockExpire  avgt   25  113330.799 ± 17221.271  ns/op
DefaultReactiveLockBenchmark.testTryLock     avgt   25    6540.598 ±   325.970  ns/op
```


#### CLHReactiveLock

> See `pro.chenggang.project.reactive.lock.benchmark.CLHReactiveLockBenchmarkTests`

* Throughput

```txt
Benchmark                                 Mode  Cnt       Score       Error  Units
CLHReactiveLockBenchmark.testLockExpire  thrpt   25   63322.356 ±  7832.461  ops/s
CLHReactiveLockBenchmark.testTryLock     thrpt   25  623214.243 ± 24038.862  ops/s
```

* Sample Time

```txt
Benchmark                                                         Mode       Cnt           Score       Error  Units
CLHReactiveLockBenchmark.testLockExpire                         sample  17765734      125104.458 ± 13210.713  ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.00    sample                  2800.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.50    sample                  5840.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.90    sample                 29536.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.95    sample                 88448.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.99    sample                501760.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.999   sample               2199552.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.9999  sample              10787659.776              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p1.00    sample            5653921792.000              ns/op
CLHReactiveLockBenchmark.testTryLock                            sample  40584590       16660.122 ±   826.936  ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.00          sample                   203.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.50          sample                  2744.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.90          sample                  6520.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.95          sample                 19840.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.99          sample                136192.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.999         sample                922624.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.9999        sample               6476111.053              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p1.00          sample            2092957696.000              ns/op
```

* Average Time

```txt
Benchmark                                Mode  Cnt       Score       Error  Units
CLHReactiveLockBenchmark.testLockExpire  avgt   25  127635.344 ± 13423.417  ns/op
CLHReactiveLockBenchmark.testTryLock     avgt   25   13006.849 ±   483.094  ns/op
```

#### MCSReactiveLock

> See `pro.chenggang.project.reactive.lock.benchmark.MCSReactiveLockBenchmarkTests`

* Throughput

```txt
Benchmark                                 Mode  Cnt       Score       Error  Units
CLHReactiveLockBenchmark.testLockExpire  thrpt   25   63137.995 ±  7652.748  ops/s
CLHReactiveLockBenchmark.testTryLock     thrpt   25  647349.972 ± 12047.181  ops/s
```

* Sample Time

```txt
Benchmark                                                         Mode       Cnt           Score       Error  Units
CLHReactiveLockBenchmark.testLockExpire                         sample  17801805      129631.454 ± 12975.130  ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.00    sample                  2864.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.50    sample                  5952.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.90    sample                 28832.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.95    sample                 84864.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.99    sample                508928.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.999   sample               2327322.624              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p0.9999  sample              13860864.000              ns/op
CLHReactiveLockBenchmark.testLockExpire:testLockExpire·p1.00    sample            4420796416.000              ns/op
CLHReactiveLockBenchmark.testTryLock                            sample  40136633       15044.424 ±   436.492  ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.00          sample                   102.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.50          sample                  3840.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.90          sample                  9024.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.95          sample                 23232.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.99          sample                146176.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.999         sample                835584.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p0.9999        sample               3620864.000              ns/op
CLHReactiveLockBenchmark.testTryLock:testTryLock·p1.00          sample             273678336.000              ns/op
```

* Average Time

```txt
Benchmark                                Mode  Cnt       Score       Error  Units
CLHReactiveLockBenchmark.testLockExpire  avgt   25  133124.659 ± 15444.404  ns/op
CLHReactiveLockBenchmark.testTryLock     avgt   25   13092.472 ±   193.290  ns/op
```

#### RedisReactiveLock

> See `pro.chenggang.project.reactive.lock.benchmark.RedisReactiveLockBenchmarkTests`
> Benchmarking using a local redis server instead of an embedded server

* Throughput

```txt
Benchmark                                           Mode  Cnt        Score       Error  Units
RedisReactiveLockRegistryBenchmark.testLockExpire  thrpt   25    75001.195 ±  9350.136  ops/s
RedisReactiveLockRegistryBenchmark.testTryLock     thrpt   25  1924446.246 ± 92731.764  ops/s
```

* Sample Time

```txt
Benchmark                                                                   Mode       Cnt           Score      Error  Units
RedisReactiveLockRegistryBenchmark.testLockExpire                         sample  20347533      103026.470 ± 8987.630  ns/op
RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.00    sample                  2480.000             ns/op
RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.50    sample                  4992.000             ns/op
RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.90    sample                  8184.000             ns/op
RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.95    sample                 24032.000             ns/op
RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.99    sample                229376.000             ns/op
RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.999   sample               2301952.000             ns/op
RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p0.9999  sample              37814272.000             ns/op
RedisReactiveLockRegistryBenchmark.testLockExpire:testLockExpire·p1.00    sample            3766484992.000             ns/op
RedisReactiveLockRegistryBenchmark.testTryLock                            sample  65206393        4690.081 ±   31.527  ns/op
RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.00          sample                   773.000             ns/op
RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.50          sample                  2728.000             ns/op
RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.90          sample                  3244.000             ns/op
RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.95          sample                  3416.000             ns/op
RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.99          sample                 18560.000             ns/op
RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.999         sample                257280.000             ns/op
RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p0.9999        sample               2826240.000             ns/op
RedisReactiveLockRegistryBenchmark.testTryLock:testTryLock·p1.00          sample              43646976.000             ns/op
```

* Average Time

```txt
Benchmark                                          Mode  Cnt       Score       Error  Units
RedisReactiveLockRegistryBenchmark.testLockExpire  avgt   25  105464.905 ± 10506.329  ns/op
RedisReactiveLockRegistryBenchmark.testTryLock     avgt   25    4160.035 ±   279.581  ns/op
```