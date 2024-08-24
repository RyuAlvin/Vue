package org.yeahicode.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "--------------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "--------------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "--------------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        int i = 10 / 0;
        return "--------------testD";
    }

    @GetMapping("/testHostKey")
    @SentinelResource(value = "/testHostKey", blockHandler = "testHostKey_BlockHandler")
    public String testHostKey(@RequestParam(value = "k1", required = false) String k1, @RequestParam(value = "k2", required = false) String k2) {
        int i = 10 / 0;
        return "----------------testHostKey";
    }

    public String testHostKey_BlockHandler(String k1, String k2, BlockException blockException) {
        String message = blockException.getMessage();
        return "----------------testHostKey的兜底方法/(ㄒoㄒ)/~~，error=" + message;
    }
}
