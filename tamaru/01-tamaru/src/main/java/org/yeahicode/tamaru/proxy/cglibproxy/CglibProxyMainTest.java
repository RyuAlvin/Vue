package org.yeahicode.tamaru.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyMainTest {
    public static void main(String[] args) {
        MyMethodInterceptor mi = new MyMethodInterceptor();
        /**
         * 代理对象没有实现接口的时候，则通过CGLIB实现动态代理，为代理对象生成子类作为代理
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MySuperClass.class);
        enhancer.setCallback(mi);
        MySuperClass proxy = (MySuperClass) enhancer.create();
        String result = proxy.run("RyuAlvin");
        System.out.println(result);
    }
}
