package com.rj.rabbitmq.mq_simple.config;

/**
 * 队列名字的常量类，也就是routingKey的常量类
 * 发送方将消息发送到该队列中，然后接收方需要从该队列获取
 */
public interface RoutingKeyName {
    String SIMPLE_EAT = "eat";
    String SIMPLE_DRINK = "drink";
}
