package com.rj.rabbitmq.mq_work.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    @Bean
    public Queue queue_eat() {
        return new Queue("eat");
    }
}
