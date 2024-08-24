package org.yeahicode.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private static final String PAYMENT_URL = "http://consul-provider-payment";

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/consul")
    public String consumerPaymentConsul() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return result;
    }
}
