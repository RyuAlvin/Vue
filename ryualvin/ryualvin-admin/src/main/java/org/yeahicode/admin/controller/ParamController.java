package org.yeahicode.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParamController {

    @Autowired
    Environment env;

    @GetMapping("/getParam")
    public Map<String, Object> getParam() {
        String addr = env.getProperty("ryualvin.address");
        String javaHome = env.getProperty("JAVA_HOME");
        Map<String, Object> map = new HashMap<>();
        map.put("addr", addr);
        map.put("javaHome", javaHome);
        return map;
    }
}
