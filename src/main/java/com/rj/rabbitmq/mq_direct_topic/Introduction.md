# Direct和Topic模式

两者的唯一区别就是匹配模式

与Fanout模式不同

**发送者**除了需要设定交换机以外，还可以设定`routingKey`，这个key对应的就是绑定交换机的时候设定的`with(routing key)`

如果是topic模式，则模糊匹配，如果是direct模式则是精确匹配

可以说，控制的是发送端，如果不满足条件，那么发送的消息则不会为交换机接收

**消费者**接收消息，看的是队列queue，而不是routingkey，事实上，你也无法再@RabbitListener注解中去设定queue的名字，因为如果这个queue没有注入到RabbitMQ，会报错的
