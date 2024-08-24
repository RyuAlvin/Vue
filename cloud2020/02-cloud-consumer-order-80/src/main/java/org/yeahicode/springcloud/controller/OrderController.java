package org.yeahicode.springcloud.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.yeahicode.springcloud.entities.CommonResult;
import org.yeahicode.springcloud.entities.Payment;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";
    /**
     * 通过服务名去服务注册信息中获取服务信息，再通过@LoadBalanced负载均衡调用集群中的服务
     */
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/postForEntity")
    public CommonResult postForEntity(Payment payment) {
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            System.out.println("statusCodeValue=" + entity.getStatusCodeValue());
            HttpHeaders headers = entity.getHeaders();
            for (Map.Entry<String, List<String>> stringListEntry : headers.entrySet()) {
                System.out.println("key=" + stringListEntry.getKey() + "，value=" + stringListEntry.getValue());
            }
            CommonResult body = entity.getBody();
            body.getData();
            System.out.println("body=" + body);
        }
        return entity.getBody();
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult getForEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            System.out.println("statusCodeValue=" + entity.getStatusCodeValue());
            HttpHeaders headers = entity.getHeaders();
            for (Map.Entry<String, List<String>> stringListEntry : headers.entrySet()) {
                System.out.println("key=" + stringListEntry.getKey() + "，value=" + stringListEntry.getValue());
            }
            CommonResult body = entity.getBody();
            System.out.println("body=" + body);
        }
        return entity.getBody();
    }

    @GetMapping("/consumer/payment/zipkin")
    public String consumerPaymentZipkin() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
        return result;
    }
}
