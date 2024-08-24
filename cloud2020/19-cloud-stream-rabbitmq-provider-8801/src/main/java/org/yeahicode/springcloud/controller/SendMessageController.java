package org.yeahicode.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeahicode.springcloud.service.IMessageProvider;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send() {
        return messageProvider.send();
    }
}
