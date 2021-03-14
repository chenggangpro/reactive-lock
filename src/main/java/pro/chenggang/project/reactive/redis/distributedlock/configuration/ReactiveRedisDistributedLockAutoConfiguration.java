package pro.chenggang.project.reactive.redis.distributedlock.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.util.StringUtils;
import pro.chenggang.project.reactive.redis.distributedlock.core.ReactiveRedisDistributedLockRegistry;
import pro.chenggang.project.reactive.redis.distributedlock.properties.RedisDistributedLockProperties;
import reactor.core.publisher.Flux;

/**
 * ReactiveRedisLockRegistry AutoConfiguration
 * @author: chenggang
 * @date 2021-03-14.
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedisReactiveAutoConfiguration.class)
@ConditionalOnClass({ReactiveRedisDistributedLockRegistry.class, RedisReactiveAutoConfiguration.class, ReactiveRedisConnectionFactory.class, Flux.class})
public class ReactiveRedisDistributedLockAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(RedisDistributedLockProperties.class)
    @ConfigurationProperties(RedisDistributedLockProperties.REDIS_LOCK_PROPERTIES_PREFIX)
    public RedisDistributedLockProperties redisDistributedLockProperties(){
        return new RedisDistributedLockProperties();
    }

    @Bean
    @ConditionalOnMissingBean(ReactiveRedisDistributedLockRegistry.class)
    public ReactiveRedisDistributedLockRegistry redisLockRegistry(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory, RedisDistributedLockProperties redisDistributedLockProperties){
        String keyPrefix = StringUtils.isEmpty(redisDistributedLockProperties.getRegistryKeyPrefix()) ? "REDIS_DISTRIBUTED_LOCK" : redisDistributedLockProperties.getRegistryKeyPrefix();
        ReactiveRedisDistributedLockRegistry reactiveRedisDistributedLockRegistry = new ReactiveRedisDistributedLockRegistry(reactiveRedisConnectionFactory, keyPrefix, redisDistributedLockProperties.getExpireAfter(),redisDistributedLockProperties.getExpireAfter());
        log.info("Load Reactive Redis Distributed Lock Registry Success,RegistryKey Prefix:{},Default Expire Duration:{}",keyPrefix,redisDistributedLockProperties.getExpireAfter());
        return reactiveRedisDistributedLockRegistry;
    }

}
