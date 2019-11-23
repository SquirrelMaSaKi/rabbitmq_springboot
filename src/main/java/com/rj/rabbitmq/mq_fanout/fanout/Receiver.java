package com.rj.rabbitmq.mq_fanout.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = "drink")
    public void receiveMessage1(String msg) {
        System.out.println("fanoutOne接收到的消息：" + msg);
    }

    @RabbitListener(queues = "drink")
    public void receiveMessage2(String msg) {
        System.out.println("fanoutTwo接收到的消息：" + msg);
    }
}
