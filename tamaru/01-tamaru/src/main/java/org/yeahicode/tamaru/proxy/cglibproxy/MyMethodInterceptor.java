package org.yeahicode.tamaru.proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置增强...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("后置增强...");
        return result;
    }
}
