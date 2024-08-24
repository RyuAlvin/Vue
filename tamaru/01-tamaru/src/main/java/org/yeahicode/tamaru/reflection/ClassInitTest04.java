package org.yeahicode.tamaru.reflection;

public class ClassInitTest04 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}

class A{
    static {
        m = 100;
        System.out.println("static代码块执行了。。。");
    }
    static int m = 300;


    public A() {
        System.out.println("构造函数执行了。。。");
    }
}