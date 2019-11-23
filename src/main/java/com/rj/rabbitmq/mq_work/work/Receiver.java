package com.rj.rabbitmq.mq_work.work;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Receiver {
    @RabbitListener(queues = "eat")
    public void receiveMessage_eat1(String msg) {
        System.out.println("eat1号位接收消息: " + msg);
    }
    @RabbitListener(queues = "eat")
    public void receiveMessage_eat2(String msg) {
        System.out.println("eat2号位接收消息: " + msg);
    }
}
