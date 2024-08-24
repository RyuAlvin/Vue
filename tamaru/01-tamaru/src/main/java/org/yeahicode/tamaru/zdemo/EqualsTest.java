package org.yeahicode.tamaru.zdemo;

public class EqualsTest {
    public static void main(String[] args) {
        String s1 = "HelloWorld";
        String s2 = "Hello";
        String s3 = "World";
        // 运行时执行，生成新的堆对象来承接，并指向常量池中的"HelloWorld"对象
//        String s4 = s2 + s3;
        String s4 = (s2 + s3).intern();
        // == 比较的是基础类型的值或者引用类型的堆地址是否相等
        // String重写了equals中的方法，比较的是字符串的值是否相等
        System.out.println(s1.equals(s4));
        System.out.println(s1 == s4);
    }
}
