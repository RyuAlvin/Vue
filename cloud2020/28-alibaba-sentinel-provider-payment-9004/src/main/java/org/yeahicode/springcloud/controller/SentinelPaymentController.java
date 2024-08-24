package org.yeahicode.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yeahicode.springcloud.entities.CommonResult;
import org.yeahicode.springcloud.entities.Payment;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class SentinelPaymentController {

    private static HashMap<Long, Payment> paymentInfos = new HashMap<Long, Payment>();

    static {
        paymentInfos.put(1L, new Payment(1L, UUID.randomUUID().toString().replace("-", "")));
        paymentInfos.put(2L, new Payment(2L, UUID.randomUUID().toString().replace("-", "")));
        paymentInfos.put(3L, new Payment(3L, UUID.randomUUID().toString().replace("-", "")));
    }

    @Value("${server.port}")
    String port;

    @GetMapping("/payment/sentinel/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentInfos.get(id);
        return new CommonResult<>(200, "payment --- port:" + port + " --- Successful", payment);
    }
}
