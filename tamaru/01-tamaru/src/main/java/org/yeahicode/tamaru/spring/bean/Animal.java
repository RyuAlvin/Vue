package org.yeahicode.tamaru.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Animal implements InitializingBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean {
    private String name;

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        System.out.println("2、设置属性...");
        this.name = name;
    }

    public Animal() {
        System.out.println("1、构造函数：实例化...");
    }

    public Animal(String name) {
        this.name = name;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("############ @PostConstruct...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("############ @PreDestroy...");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3-1、Aware接口检查：BeanNameAware...setBeanName...");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3-2、Aware接口检查：BeanFactoryAware...setBeanFactory...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("3-3、Aware接口检查：ApplicationContextAware...setApplicationContext...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5、InitializingBean接口：afterPropertiesSet...");
    }

    public void customInitMethod() {
        System.out.println("6、自定义：InitMethod...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("8、DisposableBean接口：destroy...");
    }

    public void customDestroyMethod() {
        System.out.println("9、自定义：DestroyMethod...");
    }
}
