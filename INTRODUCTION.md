MQ全称为Message Queue, 消息队列（MQ）是⼀种应⽤程序对应⽤程序的通信⽅法。应⽤程序通过
读写出⼊队列的消息（针对应⽤程序的数据）来通信，⽽⽆需专⽤连接来链接它们。消息传递指的是
程序之间通过在消息中发送数据进⾏通信，⽽不是通过直接调⽤彼此来通信，直接调⽤通常是⽤于诸
如远程过程调⽤的技术。排队指的是应⽤程序通过 队列来通信。队列的使⽤除去了接收和发送应⽤程
序同时执⾏的要求。其中较为成熟的MQ产品有IBM WEBSPHERE MQ等等。
RabbitMQ是⼀个在AMQP基础上完成的，可复⽤的企业消息系统。他遵循Mozilla Public License开
源协议。
AMQP，即Advanced Message Queuing Protocol,⼀个提供统⼀消息服务的应⽤层标准⾼级消息队列
协议,是应⽤层协议的⼀个开放标准,为⾯向消息的中间件设计。基于此协议的客户端与消息中间件可传
递消息，并不受客户端/中间件不同产品，不同的开发语⾔等条件的限制。Erlang中的实现有
RabbitMQ等。

# 模式分类

RabbitMQ分为了Simple模式、work模式、fanout模式、Direct模式和Topic模式

你可以通过配置文件将queue队列注册到RabbitMq，可以通过springboot配置文件进行相关的属性配置【详见mq_wor包】

Simple模式和work模式不需要交换机，而是直接将消息发送到队列，接收者根据队列获取消息

fanout模式是广播模式，无论队列是否绑定到交换机，都能获取到fanout发送的消息

direct和topic，发送者发送的消息需要和交换机中绑定的队列的routingkey进行匹配，匹配成功才能放到交换机，否则无法放到交换机