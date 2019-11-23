package com.rj.rabbitmq.mq_fanout.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
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
    /**
     * 将队列注入，将在RabbitMq中注册一个eat的队列，并且后面会绑定到交换机上
     */
    @Bean
    public Queue simple_queue_eat() {
        return new Queue("eat");
    }

//    @Bean
//    public Queue simple_queue_drink() {
//        return new Queue("drink");
//    }


    /**
     * 声明交换机，并将相关的消息队列绑定
     * 这种绑定是不可消除的
     * 如果绑定了两个eat和drink，则在交换机中，这两个队列都有
     * 此时，如果sender将消息发送到eat队列，而接收方只有drink，则drink也会接收到，均分消息
     * 而eat中的消息则堆积在了交换机中，等待被消费
     */
    //声明
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutexchange");

        //参数1 交换机的名字
        //参数2 是否持久化队列, false代表消息只在内存中,如果服务器关闭后消息会丢失
        //参数3 是否自动删除,当最后一个消费者断开连接后,是否删除队列
        //参数4 一些创建参数，可以不写
        //new FanoutExchange("fanout", false, false, null);
    }
    //绑定
    @Bean
    public Binding bindFanout(FanoutExchange exchange, Queue queue) {
        return BindingBuilder.bind(queue).to(exchange);
    }
}
