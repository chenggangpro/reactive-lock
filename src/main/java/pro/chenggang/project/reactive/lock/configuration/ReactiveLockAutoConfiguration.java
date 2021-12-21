package pro.chenggang.project.reactive.lock.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import pro.chenggang.project.reactive.lock.core.ReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.core.defaults.DefaultReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.core.defaults.RedisReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.properties.RedisReactiveLockProperties;
import reactor.core.publisher.Flux;

/**
 * ReactiveRedisLockRegistry AutoConfiguration
 * @author: chenggang
 * @date 2021-03-14.
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedisReactiveAutoConfiguration.class)
@ConditionalOnClass({ReactiveLockRegistry.class, RedisReactiveAutoConfiguration.class, ReactiveRedisConnectionFactory.class, Flux.class})
public class ReactiveLockAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(RedisReactiveLockProperties.class)
    @ConfigurationProperties(RedisReactiveLockProperties.REDIS_LOCK_PROPERTIES_PREFIX)
    public RedisReactiveLockProperties redisReactiveLockProperties(){
        return new RedisReactiveLockProperties();
    }

    @Bean
    @ConditionalOnBean(ReactiveRedisConnectionFactory.class)
    @ConditionalOnExpression("@redisReactiveLockProperties.reactiveLockType.contains(T(pro.chenggang.project.reactive.lock.option.ReactiveLockType).REDIS)")
    public ReactiveLockRegistry redisReactiveLockRegistry(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, RedisReactiveLockProperties redisReactiveLockProperties){
        ReactiveLockRegistry redisReactiveLockRegistry = new RedisReactiveLockRegistry(reactiveRedisConnectionFactory, redisReactiveLockProperties.getExpireEvictIdle(),redisReactiveLockProperties.getExpireAfter(),redisReactiveLockProperties.getRegistryKeyPrefix());
        log.info("Load Reactive Redis Reactive Lock Registry Success,RegistryKey Prefix:{},Default Expire Duration:{}",redisReactiveLockProperties.getRegistryKeyPrefix(), redisReactiveLockProperties.getExpireAfter());
        return redisReactiveLockRegistry;
    }

    @Bean
    @ConditionalOnExpression("@redisReactiveLockProperties.reactiveLockType.contains(T(pro.chenggang.project.reactive.lock.option.ReactiveLockType).DEFAULT)")
    public ReactiveLockRegistry defaultReactiveLockRegistry(RedisReactiveLockProperties redisReactiveLockProperties){
        ReactiveLockRegistry reactiveLockRegistry = new DefaultReactiveLockRegistry(redisReactiveLockProperties.getExpireEvictIdle(),redisReactiveLockProperties.getExpireAfter());
        log.info("Load Default Reactive Lock Registry Success,Default Expire Duration:{}", redisReactiveLockProperties.getExpireAfter());
        return reactiveLockRegistry;
    }

}
