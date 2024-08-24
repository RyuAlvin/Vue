package org.yeahicode.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class DelayListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println("接收订单数据：" + new String(message.getBody()));
            System.out.println("更新库存");
//            int i = 10 / 0;
            channel.basicAck(deliveryTag, true);//手动确认签收
            System.out.println("更新库存成功");
        } catch (Exception e) {
            System.out.println("更新库存数据异常");
            // 让消息重回死信队列，好让其他消费者消费
            channel.basicNack(deliveryTag, true, true);
        }
    }
}
