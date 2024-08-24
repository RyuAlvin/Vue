package org.yeahicode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.yeahicode.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
/**
 * 在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
 *  限定该负载均衡策略只适用于请求服务”CLOUD-PAYMENT-SERVICE“
 */
@RibbonClient(configuration = MySelfRule.class, name = "CLOUD-PAYMENT-SERVICE")
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
    }
}
