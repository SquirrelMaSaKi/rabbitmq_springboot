package com.rj.rabbitmq.mq_direct_topic.direct_topic;

import com.rj.rabbitmq.mq_fanout.config.RoutingKeyName;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate template;

    public void send(String msg) {
        template.convertAndSend("directexchange", RoutingKeyName.SIMPLE_DRINK, msg);
    }

    public void send2(String rometingkey, String msg) {
        template.convertAndSend("topicexchange", rometingkey, msg);
    }
}
