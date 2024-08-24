package org.yeahicode.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class DlxListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println("接收消息：" + new String(message.getBody()));
            int i = 10 / 0;
            channel.basicAck(deliveryTag, true);//手动确认签收
            System.out.println("接收消息成功");
        } catch (Exception e) {

            System.out.println("接收消息异常");
            // 不让消息重回普通队列，因为要让消息转发至死信队列
            channel.basicNack(deliveryTag, true, false);
        }
    }
}
