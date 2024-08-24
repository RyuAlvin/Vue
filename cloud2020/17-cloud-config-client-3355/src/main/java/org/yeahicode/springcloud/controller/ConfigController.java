package org.yeahicode.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String info;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String config() {
        return "config => " + info + "，port => " + port;
    }
}
