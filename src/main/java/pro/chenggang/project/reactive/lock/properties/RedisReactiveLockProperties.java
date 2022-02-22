package pro.chenggang.project.reactive.lock.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pro.chenggang.project.reactive.lock.option.ReactiveLockType;

import java.time.Duration;
import java.util.Set;

/**
 * Redis Reactive Lock Properties Configuration
 *
 * @author Gang Cheng
 * @date 2021/03/14
 */
@Getter
@Setter
@ToString
public class RedisReactiveLockProperties {

    /**
     * The constant REDIS_LOCK_PROPERTIES_PREFIX.
     */
    public static final String REDIS_LOCK_PROPERTIES_PREFIX = "lock.redis.reactive";

    /**
     * global registry key prefix
     */
    private String registryKeyPrefix;

    /**
     * max redis key expire duration
     */
    private Duration expireAfter = Duration.ofMinutes(1);

    /**
     * expire evict idle duration
     */
    private Duration expireEvictIdle = Duration.ofSeconds(3);

    /**
     * reactive lock type
     */
    private Set<ReactiveLockType> reactiveLockType = Set.of(ReactiveLockType.DEFAULT);
}
