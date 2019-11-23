package com.rj.rabbitmq.mq_work.work;

import com.rj.rabbitmq.mq_work.config.RoutingKeyName;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate template;

    public void sendMessage(String msg1) {
        for (int i = 100; i > 0 ; i--) {
            template.convertAndSend(RoutingKeyName.SIMPLE_EAT, msg1+i);
        }
    }
}
