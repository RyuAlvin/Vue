package org.yeahicode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring-rabbitmq-consumer.xml")
public class Broker2onsumerTest {

    @Test
    public void test01() {
        while (true) {

        }
    }
}
