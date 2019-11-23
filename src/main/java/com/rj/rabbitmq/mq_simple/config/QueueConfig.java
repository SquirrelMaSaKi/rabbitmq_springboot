package com.rj.rabbitmq.mq_simple.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个类用来配置队列名字，这样在发送端声明routingKey的名字后，可以将消息放到这个队列
 * 接收端使用这个key就可以接收相关的消息
 */
@Configuration //表示该类是个配置类
public class QueueConfig {
    @Bean //将队列注入
    public Queue simple_queue_eat() {
        return new Queue("eat");
    }

    @Bean
    public Queue simple_queue_drink() {
        return new Queue("drink");
    }
}
