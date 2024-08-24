package org.yeahicode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yeahicode.rabbitmq.listener.FanoutListener1;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-rabbitmq-consumer.xml")
public class SpringConsumer {

    @Autowired
    FanoutListener1 fanoutListener1;

    @Test
    public void test01() {
        while (true) {

        }
    }
}
