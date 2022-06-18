package pro.chenggang.project.reactive.lock.configuration.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import pro.chenggang.project.reactive.lock.core.ReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.core.redis.RedisReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.properties.ReactiveLockProperties;
import reactor.core.publisher.Flux;

/**
 * Redis reactive lock auto configuration
 *
 * @author Gang Cheng
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedisReactiveAutoConfiguration.class)
@ConditionalOnClass({RedisReactiveLockRegistry.class, ReactiveRedisConnectionFactory.class, Flux.class})
public class RedisReactiveLockRegistryAutoConfiguration {

    /**
     * Redis reactive lock registry.
     *
     * @param reactiveRedisConnectionFactory the reactive redis connection factory
     * @param reactiveLockProperties         the redis reactive lock properties
     * @return the reactive lock registry
     */
    @Bean
    @ConditionalOnBean(ReactiveRedisConnectionFactory.class)
    public ReactiveLockRegistry redisReactiveLockRegistry(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, ReactiveLockProperties reactiveLockProperties) {
        ReactiveLockRegistry redisReactiveLockRegistry = new RedisReactiveLockRegistry(reactiveRedisConnectionFactory, reactiveLockProperties.getExpireEvictIdle(), reactiveLockProperties.getExpireAfter(), reactiveLockProperties.getRegistryKeyPrefix());
        log.info("Load Reactive Redis Reactive Lock Registry Success,RegistryKey Prefix:{},Default Expire Duration:{}", reactiveLockProperties.getRegistryKeyPrefix(), reactiveLockProperties.getExpireAfter());
        return redisReactiveLockRegistry;
    }
}
