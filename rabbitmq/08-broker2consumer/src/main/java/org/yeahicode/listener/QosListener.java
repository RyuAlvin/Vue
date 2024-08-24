package org.yeahicode.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class QosListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(1000);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        System.out.println("接收消息：" + new String(message.getBody()));
        channel.basicAck(deliveryTag, true);//手动确认签收
    }
}
