package org.yeahicode.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackHystrixService implements PaymentHystrixService{
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackHystrixService 统一异常处理";
    }
}
