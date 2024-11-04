package org.yeahicode.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParamController {

    @Autowired
    private Environment env;

    @Value("${ryualvin.address}")
    private String addrField;

    @Value("${JAVA_HOME}")
    private String javaHomeField;

    @GetMapping("/getParam1")
    public Map<String, Object> getParam1() {
        String addr = env.getProperty("ryualvin.address");
        String javaHome = env.getProperty("JAVA_HOME");
        Map<String, Object> map = new HashMap<>();
        map.put("addr", addr);
        map.put("javaHome", javaHome);
        return map;
    }

    @GetMapping("/getParam2")
    public Map<String, Object> getParam2() {
        Map<String, Object> map = new HashMap<>();
        map.put("addr", addrField);
        map.put("javaHome", javaHomeField);
        return map;
    }
}
