package com.rj.rabbitmq.mq_simple.simple;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = "eat", autoStartup = "true") //定义了接收哪个队列的消息
    public void receiveMessage_eat(String msg) {
        System.out.println("接收到了eat_simple类型前端消息:" + msg);
    }

    @RabbitListener(queues = "drink", autoStartup = "true")
    public void receiveMessage_drink(String msg) {
        System.out.println("接收到的drink_simple类型前端消息："+msg);
    }

    //由于drink的消息被上面的接收了，所以不能再接收了
    @RabbitListener(queues = "drink", autoStartup = "true")
    public void receiveMessage_drink2(String msg) {
        System.out.println("接收到的drink_simple2类型前端消息："+msg);
    }
}
