package com.solider.rocketmq_use_fast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RocketmqUseFastApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqUseFastApplication.class, args);
    }

}
