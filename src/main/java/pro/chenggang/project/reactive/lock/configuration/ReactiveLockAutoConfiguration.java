package pro.chenggang.project.reactive.lock.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import pro.chenggang.project.reactive.lock.core.ReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.properties.ReactiveLockProperties;
import reactor.core.publisher.Flux;

import static pro.chenggang.project.reactive.lock.properties.ReactiveLockProperties.LOCK_PROPERTIES_PREFIX;

/**
 * ReactiveRedisLockRegistry AutoConfiguration
 *
 * @author Gang Cheng
 * @date 2021-03-14.
 */
@Slf4j
@Import({ReactiveLockAutoConfigurationImportSelector.class})
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(RedisReactiveAutoConfiguration.class)
@ConditionalOnClass({ReactiveLockRegistry.class, RedisReactiveAutoConfiguration.class, ReactiveRedisConnectionFactory.class, Flux.class})
public class ReactiveLockAutoConfiguration {

    /**
     * Redis reactive lock properties.
     *
     * @return the redis reactive lock properties
     */
    @Bean
    @ConditionalOnMissingBean(ReactiveLockProperties.class)
    @ConfigurationProperties(LOCK_PROPERTIES_PREFIX)
    public ReactiveLockProperties redisReactiveLockProperties() {
        return new ReactiveLockProperties();
    }

}
