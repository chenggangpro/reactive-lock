package pro.chenggang.project.reactive.redis.distributedlock.embedded;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

/**
 * @author: chenggang
 * @date 2021-03-14.
 */
@Configuration
public class EmbeddedRedisServerConfiguration {

    @Bean(initMethod = "start",destroyMethod = "stop")
    public RedisServer redisServer() throws Exception{
        return new RedisServer(6379);
    }
}
