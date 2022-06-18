package pro.chenggang.project.reactive.lock.embedded;

import org.springframework.context.annotation.Bean;
import redis.embedded.RedisServer;

/**
 * Embedded Redis Server Configuration
 * @author Gang Cheng
 * @date 2021-03-14.
 */
//@Configuration
public class EmbeddedRedisServerConfiguration {

    @Bean(initMethod = "start",destroyMethod = "stop")
    public RedisServer redisServer() throws Exception{
        return new RedisServer(6379);
    }
}
