package pro.chenggang.project.reactive.lock.configuration.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.chenggang.project.reactive.lock.configuration.ReactiveLockAutoConfiguration;
import pro.chenggang.project.reactive.lock.core.ReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.core.defaults.DefaultReactiveLockRegistry;
import pro.chenggang.project.reactive.lock.properties.ReactiveLockProperties;
import reactor.core.publisher.Flux;

/**
 * Default reactive lock auto configuration
 *
 * @author Gang Cheng
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(ReactiveLockAutoConfiguration.class)
@ConditionalOnClass({DefaultReactiveLockRegistry.class, Flux.class})
public class DefaultReactiveLockRegistryAutoConfiguration {

    /**
     * Default reactive lock registry.
     *
     * @param reactiveLockProperties the redis reactive lock properties
     * @return the reactive lock registry
     */
    @Bean
    public ReactiveLockRegistry defaultReactiveLockRegistry(ReactiveLockProperties reactiveLockProperties) {
        ReactiveLockRegistry reactiveLockRegistry = new DefaultReactiveLockRegistry(reactiveLockProperties.getExpireEvictIdle(), reactiveLockProperties.getExpireAfter());
        log.info("Load Default Reactive Lock Registry Success,Default Expire Duration:{}", reactiveLockProperties.getExpireAfter());
        return reactiveLockRegistry;
    }
}

