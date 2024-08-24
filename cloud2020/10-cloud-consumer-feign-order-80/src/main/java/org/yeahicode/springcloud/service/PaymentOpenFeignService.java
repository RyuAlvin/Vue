package org.yeahicode.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.yeahicode.springcloud.entities.CommonResult;

@FeignClient(value="CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentOpenFeignService {
    @GetMapping("/payment/get/{id}")
    CommonResult get(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String paymentTimeout();
}
