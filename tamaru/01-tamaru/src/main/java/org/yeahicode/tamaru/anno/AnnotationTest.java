package org.yeahicode.tamaru.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationTest {
    @MyAnnotation1(age = 18, schools = {"清华大学", "东京大学"})
    public void test01() {

    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
// SOURCE：只作用于源码中，在编译期间会被丢弃，即没有实际作用，基本不用此种时机
// CLASS：编译为.class文件时
// RUNTIME：运行时
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
    // 如果不指定默认值，则使用注解时必须传递该参数，否则通不过编译
    // 注解中的成员变量不能使用包装类型、自定义的类型
    String id() default "";

    int age();

    String name() default "Ryu";

    String[] schools() default {};
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    String id() default "";

    int age();

    String name() default "Ryu";
}
