package org.yeahicode;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 */
public class Consumer_PubSub1_Routing {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1、创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2、配置连接参数
        factory.setHost("192.168.182.100");//主机
        factory.setPort(5672);//端口
        factory.setUsername("ryualvin");//用户名
        factory.setPassword("xxxxxx");//密码
        factory.setVirtualHost("/ryu");//虚拟分区（可理解为MySQL中库的概念）
        // 3、创建连接
        Connection connection = factory.newConnection();
        // 4、创建频道
        Channel channel = connection.createChannel();
        // 5、创建队列
        /**
         * (String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
         * 1、queue：队列名称
         * 2、durable：是否持久化，当mq重启后还在
         * 3、exclusive：(为啥这里设置为true，无法生成队列？）
         *      * 是否独占，只能有一个消费者监听这队列
         *      * 当连接关闭时，是否删除队列
         * 4、autoDelete：是否自动删除，当没有消费者时，自动删除
         * 5、arguments：参数
         */
        // 如果没有一个名字叫"hello_world"的队列，则会创建该队列，有的话不创建并使用
        channel.queueDeclare("test_exchange_queue1", true, false, false, null);
        // 6、接收消息
        Consumer consumer = new DefaultConsumer(channel) {
            /**
             * @param consumerTag：唯一标识
             * @param envelope：可获取发送方的交换机、路由规则等信息
             * @param properties：配置信息
             * @param body：消息体
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(String.format("body = %s", new String(body)));
                System.out.println("test_exchange_queue1 ---> 将错误日志信息保存到数据库");
            }
        };
        /**
         * (String queue, boolean autoAck, Consumer callback)
         * 1、queue：接收消息的队列名称
         * 2、autoAck：是否自动确认
         * 3、callback：回调函数（消费后的处理）
         */
        channel.basicConsume("test_exchange_queue1", true, consumer);
    }
}
