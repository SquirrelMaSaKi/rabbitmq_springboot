package com.rj.rabbitmq.mq_direct_topic.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个类用来配置队列名字，这样在发送端声明routingKey的名字后，可以将消息放到这个队列
 * 接收端使用这个key就可以接收相关的消息
 *
 * 【注意】
 * queue和romotingkey，当指明要绑定交换机的时候，就发生了变化
 * 如果注入了queue而没有romentingkey，则默认以romentingkey去找队列，进行发送和接收
 * 如果注入了queue且设置了romentingkey，则romentingkey便是字符匹配，这里需要详看Direct和Topic模式
 */
@Configuration //表示该类是个配置类
public class QueueConfig {

    @Bean
    public Queue eat() {
        return new Queue("eat");
    }

    @Bean
    public Queue drink() {
        return new Queue("drink");
    }

    //声明DirectExchange
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directexchange");
    }
    //绑定
    @Bean
    public Binding bindDirect(DirectExchange exchange, Queue drink){
        //精确匹配，必须是eat的字符才能发送和接收
        return BindingBuilder.bind(drink).to(exchange).with(RoutingKeyName.SIMPLE_DRINK);
    }

    //声明TopicExchange
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicexchange");
    }
    //绑定
    @Bean
    public Binding bindTopic(TopicExchange exchange, Queue eat) {
        //模糊匹配 符号“#”匹配⼀个或多个
        //词，符号“*”匹配不多不少⼀个词。因此“audit.#”能够匹配到“audit.irs.corporate”，但
        //是“audit.” 只会匹配到“audit.irs
        return BindingBuilder.bind(eat).to(exchange).with("*.batman");
    }

}
