package org.yeahicode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-rabbitmq-producer.xml")
public class Producer2brokerTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testConfirm() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    System.out.println("发送成功");
                } else {
                    // channel error; protocol method: #method<channel.close>(reply-code=404, reply-text=NOT_FOUND - no exchange 'producer2exchange_exchange11111' in vhost '/ryu', class-id=60, method-id=40)
                    System.out.println(String.format("发送失败，原因：%s", cause));
                }
            }
        });
        rabbitTemplate.convertAndSend("producer2broker_exchange", "info.mysql.log", "Hello producer2broker confirm");
    }

    @Test
    public void testRetrun() {
        /**
         * 将Mandatory设置为true，发送失败就会将消息返回给发送者，发送者就可通过回调函数拿到发送失败信息
         */
        // 设置交换机处理失败消息的模式
        rabbitTemplate.setMandatory(true);//强制性设置为true
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println(String.format("message：", new String(message.getBody())));
                System.out.println(String.format("replyCode：", replyCode));
                System.out.println(String.format("replyText：", replyText));
                System.out.println(String.format("exchange：", exchange));
                System.out.println(String.format("routingKey：", routingKey));
            }
        });
        rabbitTemplate.convertAndSend("producer2broker_exchange", "info.mysql.log", "Hello producer2broker confirm");
    }

    @Test
    public void sendMsg() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("producer2broker_exchange", "info.mysql.log", "消费端限流测试。。。");
        }
    }

    @Test
    public void sendTtlQueue() {
        for (int i = 0; i < 10; i++) {
            // 10秒后过期
            rabbitTemplate.convertAndSend("test_ttl_exchange", "ttl.test", "Hello ttl...");
        }
    }

    @Test
    public void sendTtlMsg() {
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("5000");
                return message;
            }
        };
        rabbitTemplate.convertAndSend("test_ttl_exchange", "ttl.test", "Hello ttl...", messagePostProcessor);
    }

    @Test
    public void sendDlx() {
        // 第一种情况：生产端发送1条消息，无消费端。消息过期后，会自动转发至死信队列`test_dlx_queue`；
//        rabbitTemplate.convertAndSend("test_dlx_exchange","", "Am I Dead ?");
        // 第二种情况：生产端发送超过普通队列最大容量限制的消息数，超额的消息数会自动转发至死信队列`test_dlx_queue`；
//        for (int i = 0; i < 20; i++) {
//            rabbitTemplate.convertAndSend("test_dlx_exchange","", "Am I Dead ?");
//        }
        // 第三种情况：生产端发送1条消息，消费端拒收，并且不让其重回队列，消息会自动转发至死信队列`test_dlx_queue`；
        rabbitTemplate.convertAndSend("test_dlx_exchange", "", "Am I Dead ?");
    }

    @Test
    public void sendDelay() throws InterruptedException {
        rabbitTemplate.convertAndSend("test_dlx_exchange", "", "订单ID：xxoo，订单金额：100.00");
        for (int i = 10; i > 0; i--) {
            System.out.println("i=" + i + "。。。");
            Thread.sleep(1000);
        }
    }
}
