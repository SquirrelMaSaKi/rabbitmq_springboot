package com.rj.rabbitmq.mq_simple.simple;


import com.rj.rabbitmq.mq_simple.config.RoutingKeyName;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送器
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate template;
    //发送消息方法，里面需要队列名字和信息
    public void sendMessage(String eatmsg, String drinkmsg) {
        template.convertAndSend(RoutingKeyName.SIMPLE_EAT,eatmsg);//queue是队列，也就是routingKey
        template.convertAndSend(RoutingKeyName.SIMPLE_DRINK, drinkmsg);
    }
}
