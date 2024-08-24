package org.yeahicode.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class AckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(1000);
        /**
         * deliveryTag：当一个消费者向 RabbitMQ 注册后，会建立起一个 Channel ，
         *              RabbitMQ 会用 basic.deliver 方法向消费者推送消息，这个方法携带了一个 delivery tag，
         *              它代表了 RabbitMQ 向该 Channel 投递的这条消息的唯一标识 ID，是一个单调递增的正整数，delivery tag 的范围仅限于 Channel
         */
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {

            System.out.println("接收消息：" + new String(message.getBody()));
            int i = 10 / 0;
            /**
             * deliveryTag：broker往channel内投递这条消息的唯一标识，范围仅限于这个channel
             * multiple：是否手动确认签收多条
             */
            channel.basicAck(deliveryTag, true);//手动确认签收
            System.out.println("接收消息成功");
        } catch (Exception e) {
            /**
             * deliveryTag：broker往channel内投递这条消息的唯一标识，范围仅限于这个channel
             * multiple：是否手动确认签收多条
             * requeue：消息重回队列，broker会重新发送消息给消费端
             */
            System.out.println("接收消息异常");
            channel.basicNack(deliveryTag, true, true);
        }
    }
}
