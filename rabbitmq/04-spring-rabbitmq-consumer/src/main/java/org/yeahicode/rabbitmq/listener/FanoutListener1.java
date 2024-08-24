package org.yeahicode.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class FanoutListener1 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("队列FanoutListener1开始接收消息，消息为：" + new String(message.getBody()));
    }
}
