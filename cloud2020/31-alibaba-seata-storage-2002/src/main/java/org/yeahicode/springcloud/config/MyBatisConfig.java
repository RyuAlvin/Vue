package org.yeahicode.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"org.yeahicode.springcloud.dao"})
public class MyBatisConfig {
}
