package com.zhassurbek.mixproject.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    // import Queue from amqp
    @Bean
    public Queue createUserRegistrationQueue() {
        return new Queue("q.user-registration");
    }
}
