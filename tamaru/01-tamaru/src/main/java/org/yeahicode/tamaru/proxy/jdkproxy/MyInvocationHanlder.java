package org.yeahicode.tamaru.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHanlder implements InvocationHandler {
    private Object obj;

    public MyInvocationHanlder(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置增强...");
        Object result = method.invoke(obj, args);
        System.out.println("后置增强...");
        return result;
    }
}
