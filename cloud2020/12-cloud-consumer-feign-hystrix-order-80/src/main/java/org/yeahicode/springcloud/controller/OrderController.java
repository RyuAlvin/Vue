package org.yeahicode.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yeahicode.springcloud.service.PaymentHystrixService;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentInfo_GlobalTimeOutHandler")
public class OrderController {

    @Autowired
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/global/{id}")
//    @HystrixCommand
    public String paymentInfo_TimeOut_Global(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }

    private String paymentInfo_TimeOutHandler(Integer id) {
        return "订单服务，线程池:" + Thread.currentThread().getName() + "，paymentInfo_TimeOutHandler，id=" + id + "\t" + "(ㄒoㄒ)，调用支付接口超时或异常，请稍后在试。。。";
    }

    private String paymentInfo_GlobalTimeOutHandler() {
        return "订单服务，线程池:" + Thread.currentThread().getName() + "，全局异常处理：paymentInfo_GlobalTimeOutHandler，" + "(ㄒoㄒ)，调用支付接口超时或异常，请稍后在试。。。";
    }
}
