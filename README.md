# reactive-redis-distributed-lock
Reactive Distributed Lock Based On SpringBootReactiveRedis

### Use Case

* 1 . Make Sure Use Spring Boot Starter Dependency 

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis-reactive</artifactId>
</dependency>
```

* 2 . Configure Properties


```yaml
lock:
  redis:
    reactive:
      expire-after: 10s
      expire-evict-idle: 1s
```

* 3 . Autowired `ReactiveRedisDistributedLockRegistry` By Spring

* 4 . Use `ReactiveDistributedLock` With Your Reactive Application


> Acquire Once
 
```java
reactiveRedisDistributedLockRegistry.obtain(key)
                        .acquireOnce()
                        .filter(acquireResult -> acquireResult)
                        .flatMap(acquireResult -> Mono.just("OK"))
                        .switchIfEmpty(Mono.just("FAILED"))
```

> Acquire By Default Duration
 
```java
reactiveRedisDistributedLockRegistry.obtain(key)
                        .acquireAndExecute(Mono.just("OK"))
                        .onErrorResume(CannotAcquireLockException.class,exception -> Mono.just("Can Not Acquired Th Lock"));
```

> Acquire Whit Given Duration
 
```java
reactiveRedisDistributedLockRegistry.obtain(key)
                        .acquireAndExecute(Duration.ofSeconds(3),Mono.just("OK"))
                        .onErrorResume(CannotAcquireLockException.class,exception -> Mono.just("Can Not Acquired Th Lock"));
```

* 5 .If You Need More Detail About This Please Read The Source Code.

# Reference

* RedisLockRegistry: https://docs.spring.io/spring-integration/docs/5.3.6.RELEASE/reference/html/redis.html#redis-lock-registry
* Trigger Mono Execution After Another Mono Terminates: https://stackoverflow.com/questions/50686524/how-to-trigger-mono-execution-after-another-mono-terminates 