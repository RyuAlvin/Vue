package org.yeahicode.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeahicode.springcloud.entities.CommonResult;
import org.yeahicode.springcloud.handler.MyCustomBlockHandler;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandlerClass = MyCustomBlockHandler.class, blockHandler = "customBlockHandler1")
    public CommonResult byResource() {
        return new CommonResult(200, "byResource");
    }

//    public CommonResult byResource_BlockHandler(BlockException blockException) {
//        return new CommonResult(444, "byResource_BlockHandler");
//    }

    @GetMapping("/limit/byUrl")
    @SentinelResource(value = "byUrl", blockHandlerClass = MyCustomBlockHandler.class, blockHandler = "customBlockHandler2")
    public CommonResult byUrl() {
        return new CommonResult(200, "byUrl");
    }

//    public CommonResult byUrl_BlockHandler(BlockException blockException) {
//        return new CommonResult(444, "byUrl_BlockHandler");
//    }
}
