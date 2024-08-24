package org.yeahicode.tamaru.proxy.jdkproxy;

import java.lang.reflect.Proxy;

public class JdkProxyMainTest {
    public static void main(String[] args) {
        IMyInterface myTarget = new MyTarget();
        MyInvocationHanlder mih = new MyInvocationHanlder(myTarget);
        /**
         * 代理对象实现接口的时候，则使用JDKProxy实现动态代理，生成代理对象
         */
        IMyInterface proxy = (IMyInterface)Proxy.newProxyInstance(JdkProxyMainTest.class.getClassLoader(), MyTarget.class.getInterfaces(), mih);
        String result = proxy.run("RyuAlvin");
        System.out.println(result);
    }
}
