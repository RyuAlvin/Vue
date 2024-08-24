package org.yeahicode;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 */
public class Producer_HelloWorld {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1、创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2、配置连接参数
        factory.setHost("192.168.182.100");//主机
        factory.setPort(5672);//端口
//        factory.setUsername("ryualvin");//用户名
//        factory.setPassword("xxxxxx");//密码
//        factory.setVirtualHost("/ryu");//虚拟分区（可理解为MySQL中库的概念）
        factory.setUsername("guest");//用户名
        factory.setPassword("guest");//密码
        factory.setVirtualHost("/");//虚拟分区（可理解为MySQL中库的概念）
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
        channel.queueDeclare("hello_world", true, false, false, null);
        // 6、发送消息
        /**
         * (String exchange, String routingKey, AMQP.BasicProperties props, byte[] body)
         * 1、exchange：交换机名称，简单模式下交换机会使用默认的 ""
         * 2、routingkey：路由名称
         * 3、props：配置信息
         * 4、body：消息数据
         */
        channel.basicPublish("", "hello_world", null, "hello rabbitmq".getBytes());
        // 7、关闭资源
        // 如果不关闭连接，在MQ控制台的Connections标签里会显示，并且应用程序不停止
        channel.close();
        connection.close();
        System.out.println("消息发送成功。。。");
    }
}
