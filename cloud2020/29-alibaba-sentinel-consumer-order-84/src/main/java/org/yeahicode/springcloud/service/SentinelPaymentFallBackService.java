package org.yeahicode.springcloud.service;

import org.springframework.stereotype.Component;
import org.yeahicode.springcloud.entities.CommonResult;
import org.yeahicode.springcloud.entities.Payment;

@Component
public class SentinelPaymentFallBackService implements ISentinelPaymentService {
    @Override
    public CommonResult<Payment> getPayment(Long id) {
        return new CommonResult<Payment>(4444, "openfeign fallback ...........................");
    }
}
