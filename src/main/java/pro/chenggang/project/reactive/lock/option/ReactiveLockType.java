package pro.chenggang.project.reactive.lock.option;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pro.chenggang.project.reactive.lock.configuration.lock.CLHReactiveLockRegistryAutoConfiguration;
import pro.chenggang.project.reactive.lock.configuration.lock.DefaultReactiveLockRegistryAutoConfiguration;
import pro.chenggang.project.reactive.lock.configuration.lock.MCSReactiveLockRegistryAutoConfiguration;
import pro.chenggang.project.reactive.lock.configuration.lock.RedisReactiveLockRegistryAutoConfiguration;

/**
 * The Reactive lock type.
 *
 * @author Gang Cheng
 * @date 12/21/21.
 */
@Getter
@RequiredArgsConstructor
public enum ReactiveLockType {

    /**
     * default reactive lock type
     */
    DEFAULT(DefaultReactiveLockRegistryAutoConfiguration.class),

    /**
     * redis reactive lock
     */
    REDIS(RedisReactiveLockRegistryAutoConfiguration.class),

    /**
     * jvm reactive lock with CLH algorithm
     */
    CLH(CLHReactiveLockRegistryAutoConfiguration.class),

    /**
     * jvm reactive lock with MCS algorithm
     */
    MCS(MCSReactiveLockRegistryAutoConfiguration.class),

    ;

    private final Class<?> registryAutoConfigurationClass;
}
