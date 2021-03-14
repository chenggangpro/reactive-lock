package pro.chenggang.project.reactive.redis.distributedlock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveRedisDistributedLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveRedisDistributedLockApplication.class, args);
    }

}
