package pro.chenggang.project.reactive.lock.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.InitializingBean;
import pro.chenggang.project.reactive.lock.option.ReactiveLockType;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

/**
 * Reactive Lock Properties Configuration
 *
 * @author Gang Cheng
 * @date 2021/03/14
 */
@Getter
@Setter
@ToString
public class ReactiveLockProperties implements InitializingBean {

    /**
     * The constant LOCK_PROPERTIES_PREFIX.
     */
    public static final String LOCK_PROPERTIES_PREFIX = "lock.reactive";

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
    private Set<ReactiveLockType> reactiveLockType = new HashSet<>();


    @Override
    public void afterPropertiesSet() throws Exception {
        if(reactiveLockType.isEmpty()){
            reactiveLockType.add(ReactiveLockType.DEFAULT);
        }
    }

}
