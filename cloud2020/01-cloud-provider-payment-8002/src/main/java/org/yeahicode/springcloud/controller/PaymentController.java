package org.yeahicode.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.yeahicode.springcloud.entities.CommonResult;
import org.yeahicode.springcloud.entities.Payment;
import org.yeahicode.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j//打印日志
public class PaymentController {
    /**
     * @Autowired
     *  org.springframework.beans.factory.annotation.Autowired（spring下的注解）
     *  默认byType，多个Bean再byName（name即为方法名），
     *  所以最好使用@Qualifier来显示指定name会比较好
     * @Resource
     *  javax.annotation.Resource（jdk下的注解）
     *  默认byName，也可指定byType，或者byName+byType（不推荐），
     *  如果有多个Bean，可用byName显示指定（name即为方法名）
     */
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    String port;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******数据插入返回结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "数据插入成功！>>> port：" + port, result);
        } else {
            return new CommonResult(444, "数据插入失败！>>> port：" + port, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("******数据查询返回结果：" + result);
        if (result != null) {
            return new CommonResult(200, "数据查询成功！>>> port：" + port, result);
        } else {
            return new CommonResult(444, "数据查询失败！>>> port：" + port, null);
        }
    }

    @GetMapping("/payment/getServiceInfo")
    public Object getServiceInfo() {
        // 获取所有服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(">>> 服务名：" + service);
        }
        // 通过服务名获取该服务下的所有服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println("serviceId：" + instance.getServiceId() + "\t" + "instanceId：" + instance.getInstanceId() + "\t" + "scheme：" + instance.getScheme() + "\t" +
                    "host：" + instance.getHost() + "\t" + "port：" + instance.getPort() + "\t" + "uri：" + instance.getUri());
        }
        return services;
    }
}
