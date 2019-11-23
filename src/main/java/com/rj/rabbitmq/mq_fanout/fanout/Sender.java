package com.rj.rabbitmq.mq_fanout.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String msg) {
        amqpTemplate.convertAndSend("fanoutexchange","", msg);
    }
}
