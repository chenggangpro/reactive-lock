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
 * Reactive Lock Properties
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
     * max lock expire duration
     * default is PT3M
     */
    private Duration expireAfter = Duration.ofMinutes(3);

    /**
     * expire evict idle duration
     * default is PT1M
     */
    private Duration expireEvictIdle = Duration.ofMinutes(1);

    /**
     * lock type
     */
    private Set<ReactiveLockType> type = new HashSet<>();


    @Override
    public void afterPropertiesSet() {
        if(type.isEmpty()){
            type.add(ReactiveLockType.DEFAULT);
        }
    }

}
