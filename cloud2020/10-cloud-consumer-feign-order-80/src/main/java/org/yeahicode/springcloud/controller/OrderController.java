package org.yeahicode.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yeahicode.springcloud.entities.CommonResult;
import org.yeahicode.springcloud.service.PaymentOpenFeignService;

import javax.annotation.Resource;

@RestController
public class OrderController {

    /**
     * Feign调用服务自带负载均衡配置项
     */
    @Resource
    PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        return paymentOpenFeignService.get(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String paymentTimeout(){
        return paymentOpenFeignService.paymentTimeout();
    }
}
