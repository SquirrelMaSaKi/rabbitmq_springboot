本质与simple一样，就是进行了qos的处理，也就是告诉服务器我最多一次性处理多少消息,直到消费者给服务器应答之后才会拿下一次指定量的消息<br/>

在springboot中，我们只需要配置文件即可

如下为配置信息：

spring.rabbitmq.addresses指定client连接到的server的地址，多个以逗号分隔.

spring.rabbitmq.dynamic是否创建AmqpAdmin bean. 默认为: true)

spring.rabbitmq.host指定RabbitMQ host.默认为: localhost)

spring.rabbitmq.listener.acknowledge-mode指定Acknowledge的模式.

spring.rabbitmq.listener.auto-startup是否在启动时就启动mq，默认: true)

spring.rabbitmq.listener.concurrency指定最小的消费者数量.

spring.rabbitmq.listener.max-concurrency指定最大的消费者数量.

spring.rabbitmq.listener.prefetch指定一个请求能处理多少个消息，如果有事务的话，必须大于等于transaction数量.

spring.rabbitmq.listener.transaction-size指定一个事务处理的消息数量，最好是小于等于prefetch的数量.

spring.rabbitmq.password指定broker的密码.

spring.rabbitmq.port指定RabbitMQ 的端口，默认: 5672)

spring.rabbitmq.requested-heartbeat指定心跳超时，0为不指定.

spring.rabbitmq.ssl.enabled是否开始SSL，默认: false)

spring.rabbitmq.ssl.key-store指定持有SSL certificate的key store的路径

spring.rabbitmq.ssl.key-store-password指定访问key store的密码.

spring.rabbitmq.ssl.trust-store指定持有SSL certificates的Trust store.

spring.rabbitmq.ssl.trust-store-password指定访问trust store的密码.

spring.rabbitmq.username指定登陆broker的用户名.

spring.rabbitmq.virtual-host指定连接到broker的Virtual host.

