package org.yeahicode.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.yeahicode.springcloud.entities.CommonResult;

public class MyCustomBlockHandler {

    public static CommonResult customBlockHandler1(BlockException blockException) {
        return new CommonResult(444, "customBlockHandler1");
    }

    public static CommonResult customBlockHandler2(BlockException blockException) {
        return new CommonResult(444, "customBlockHandler2");
    }
}
