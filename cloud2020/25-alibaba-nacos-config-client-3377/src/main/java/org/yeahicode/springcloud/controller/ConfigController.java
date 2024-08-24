package org.yeahicode.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//实现配置自动刷新
public class ConfigController {

    @Value("${config.info}")
    String configInfo;

    @GetMapping("/config")
    public String config() {
        return configInfo;
    }
}
