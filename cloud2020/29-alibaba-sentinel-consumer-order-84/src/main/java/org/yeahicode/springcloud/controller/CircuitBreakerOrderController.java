package org.yeahicode.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.yeahicode.springcloud.entities.CommonResult;
import org.yeahicode.springcloud.entities.Payment;
import org.yeahicode.springcloud.service.ISentinelPaymentService;

import javax.annotation.Resource;

@RestController
public class CircuitBreakerOrderController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${provider-service.url}")
    String providerServiceUrl;

    @GetMapping("/order/sentinel/{id}")
//    @SentinelResource(value = "fallBack")
//    @SentinelResource(value = "fallBack", fallback = "getPayment_FallBack")
//    @SentinelResource(value = "fallBack", blockHandler = "getPayment_BlockHandler")
    @SentinelResource(value = "fallBack", fallback = "getPayment_FallBack", blockHandler = "getPayment_BlockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new IllegalArgumentException();
        }
        if (id == 5) {
            throw new NullPointerException();
        }
        CommonResult<Payment> result = (CommonResult<Payment>) restTemplate.getForObject(providerServiceUrl + "/payment/sentinel/" + id, CommonResult.class);
        return result;
    }

    public CommonResult<Payment> getPayment_BlockHandler(@PathVariable("id") Long id, BlockException e) {
        return new CommonResult<Payment>(4444, "getPayment_BlockHandler --- " + e);
    }

    public CommonResult<Payment> getPayment_FallBack(@PathVariable("id") Long id, Throwable e) {
        return new CommonResult<Payment>(4444, "getPayment_FallBack --- " + e);
    }

    @Resource
    ISentinelPaymentService sentinelPaymentService;

    @GetMapping("/order/sentinel/openfeign/{id}")
    @SentinelResource(value = "fallBack", fallback = "getPayment_FallBack", blockHandler = "getPayment_BlockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> getPaymentWithOpenFeign(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new IllegalArgumentException();
        }
        if (id == 5) {
            throw new NullPointerException();
        }
        CommonResult<Payment> result = sentinelPaymentService.getPayment(id);
        return result;
    }
}
