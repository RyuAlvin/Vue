package org.yeahicode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-rabbitmq-producer.xml")
public class SpringProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test01() {
        rabbitTemplate.convertAndSend("spring_fanout_exchange", "", "Hello Spring Fanout！11111111");
    }
}
