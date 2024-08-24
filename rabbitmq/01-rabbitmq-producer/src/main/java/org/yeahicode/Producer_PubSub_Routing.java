package org.yeahicode;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 */
public class Producer_PubSub_Routing {
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
        // 5、创建交换机
        /**
         * (String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments)
         * exchange：交换机名称
         * type：交换机分发消息规则
         * durable：是否持久化
         * autoDelete：是否自动删除
         * internal：是否内部，一般false
         * arguments：参数
         */
        channel.exchangeDeclare("test_exchange_routing", BuiltinExchangeType.DIRECT, true, false, false, null);
        // 6、创建队列
        /**
         * (String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
         * queue：队列名称
         * durable：是否持久化
         * exclusive：是否独占
         * autoDelete：是否自动删除
         * arguments：参数
         */
        channel.queueDeclare("test_exchange_queue1", true, false, false, null);
        channel.queueDeclare("test_exchange_queue2", true, false, false, null);
        // 7、绑定交换机和队列
        /**
         * (String queue, String exchange, String routingKey)
         * queue：绑定队列名称
         * exchange：绑定交换机名称
         * routingKey：按照什么规则绑定
         */
        // 将error级别的日志信息分发给队列1处理，保存到数据库
        channel.queueBind("test_exchange_queue1", "test_exchange_routing", "error");
        // 将info、warning、error级别的日志信息分发给队列2处理，打印到控制台
        channel.queueBind("test_exchange_queue2", "test_exchange_routing", "info");
        channel.queueBind("test_exchange_queue2", "test_exchange_routing", "warning");
        channel.queueBind("test_exchange_queue2", "test_exchange_routing", "error");
        // 8、发送消息
        /**
         * (String exchange, String routingKey, AMQP.BasicProperties props, byte[] body)
         * exchange：交换机名称
         * routingKey：分发消息规则
         * props：配置信息
         * body：消息内容
         */
        String msg = "日志：调用了findAll方法，日志级别：info";
        // 只将消息分发给队列2
        channel.basicPublish("test_exchange_routing", "error", null, msg.getBytes());
        // 9、关闭资源
        channel.close();
        connection.close();
    }
}
