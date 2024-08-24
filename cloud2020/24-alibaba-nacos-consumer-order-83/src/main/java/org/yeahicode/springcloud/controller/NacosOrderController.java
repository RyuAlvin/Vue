package org.yeahicode.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosOrderController {

    @Autowired
    RestTemplate restTemplate;

//    private static final String SERVICE = "http://nacos-payment-provider";

    @Value("${service-url.nacos-payment-service}")
    String serviceUrl;

    @GetMapping("/order/nacos/getPayment/{id}")
    public String getPayment(@PathVariable("id") String id) {
        String result = restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
        return result;
    }
}