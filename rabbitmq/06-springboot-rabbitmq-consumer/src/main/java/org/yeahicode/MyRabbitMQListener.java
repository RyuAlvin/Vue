package org.yeahicode;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitMQListener {

    @RabbitListener(queues = "boot_queue")
    public void getMessage(Message message) {
        System.out.println(new String(message.getBody()));
    }
}
