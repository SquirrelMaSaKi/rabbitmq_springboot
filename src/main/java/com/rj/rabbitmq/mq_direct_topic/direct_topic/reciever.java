package com.rj.rabbitmq.mq_direct_topic.direct_topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class reciever {
    @RabbitListener(queues = "drink")
    public void receiveMessage(String msg) {
        System.out.println("direct的drink消费者接收了：" + msg);
    }

    @RabbitListener(queues = "eat")
    public void receiveMessage2(String msg) {
        System.out.println("direct的eat消费了：" + msg);
    }
}
