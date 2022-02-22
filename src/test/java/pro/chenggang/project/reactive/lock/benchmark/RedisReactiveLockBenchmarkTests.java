package pro.chenggang.project.reactive.lock.benchmark;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import pro.chenggang.project.reactive.lock.core.ReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.core.defaults.RedisReactiveLockRegistry;
import reactor.blockhound.BlockHound;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * RedisReactiveLock Benchmark Tests
 * @author Gang Cheng
 * @since 1.0.0
 */
public class RedisReactiveLockBenchmarkTests {

    @BeforeTestClass
    public void init(){
        Hooks.onOperatorDebug();
        BlockHound.install();
    }

    private ChainedOptionsBuilder setupOptions(Mode mode, TimeUnit timeUnit) {
        return new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode(mode)
                .timeUnit(timeUnit)
                .warmupTime(TimeValue.seconds(5))
                .warmupIterations(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .threads(Threads.MAX)
                .jvmArgs("-Xmx4G", "-Xms4G", "-XX:+UseG1GC", "-XX:+UnlockExperimentalVMOptions", "-XX:G1NewSizePercent=40", "-XX:+ParallelRefProcEnabled");
    }

    @Test
    public void launchBenchmarkThroughput() throws Exception {
        Options opt = this.setupOptions(Mode.Throughput,TimeUnit.SECONDS).build();
        new Runner(opt).run();
    }

    @Test
    public void launchBenchmarkAverageTime() throws Exception {
        Options opt = this.setupOptions(Mode.AverageTime,TimeUnit.NANOSECONDS).build();
        new Runner(opt).run();
    }

    @Test
    public void launchBenchmarkSampleTime() throws Exception {
        Options opt = this.setupOptions(Mode.SampleTime,TimeUnit.NANOSECONDS).build();
        new Runner(opt).run();
    }

    @State(Scope.Benchmark)
    public static class RedisReactiveLockRegistryBenchmark {

        private ReactiveLockRegistry reactiveLockRegistry;
        private ReactiveRedisConnectionFactory reactiveRedisConnectionFactory = new RedisConnectionFactoryInitialization().reactiveRedisConnectionFactory();

        @Setup(Level.Trial)
        public void start() throws Exception {
            reactiveLockRegistry = new RedisReactiveLockRegistry(reactiveRedisConnectionFactory,Duration.ofSeconds(10),Duration.ofSeconds(30),"REACTIVE_LOCK_BENCHMARK");
            ((InitializingBean) reactiveLockRegistry).afterPropertiesSet();
        }

        @TearDown(Level.Trial)
        public void shutdown() throws Exception{
            ((DisposableBean) reactiveLockRegistry).destroy();
            ((LettuceConnectionFactory)reactiveRedisConnectionFactory).resetConnection();
        }

        @Benchmark
        public void testTryLock(Blackhole blackhole) {
            reactiveLockRegistry.obtain()
                    .tryLockThenExecute(
                            lockResult -> {
                                if (!lockResult) {
                                    return Mono.just(0);
                                }
                                return  Mono.just(1)
                                        .delayElement(Duration.ofSeconds(3));
                            }
                    )
                    .subscribe(blackhole::consume);
        }

        @Benchmark
        public void testLockExpire(Blackhole blackhole) {
            reactiveLockRegistry.obtain()
                    .lockThenExecute(
                            Duration.ofSeconds(10),
                            lockResult -> {
                                if (!lockResult) {
                                    return Mono.just(0);
                                }
                                return  Mono.just(1)
                                        .delayElement(Duration.ofSeconds(3));
                            }
                    )
                    .subscribe(blackhole::consume);
        }
    }
}
