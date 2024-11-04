package org.yeahicode.admin.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yeahicode.admin.controller.commons.interceptor.SecurityInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置拦截器和拦截路径
        registry.addInterceptor(securityInterceptor).addPathPatterns("/admin/v1/**");
    }
}
