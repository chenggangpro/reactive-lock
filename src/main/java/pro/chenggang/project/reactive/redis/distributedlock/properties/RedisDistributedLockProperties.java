package pro.chenggang.project.reactive.redis.distributedlock.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;

/**
 * Properties Configuration
 * @author chenggang
 * @date 2021/03/14
 */
@Getter
@Setter
@ToString
public class RedisDistributedLockProperties {

    public static final String REDIS_LOCK_PROPERTIES_PREFIX = "lock.redis.reactive";

    /**
     * global registry key prefix
     */
    private String registryKeyPrefix;

    /**
     * max redis key expire duration
     */
    private Duration expireAfter = Duration.ofSeconds(60);

    /**
     * expire evict idle duration
     */
    private Duration expireEvictIdle = Duration.ofSeconds(30);

}
