package org.yeahicode.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.yeahicode.springcloud.entities.CommonResult;
import org.yeahicode.springcloud.entities.Payment;

@FeignClient(value = "sentinel-payment-provider", fallback = SentinelPaymentFallBackService.class)
public interface ISentinelPaymentService {

    @GetMapping("/payment/sentinel/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
