package org.yeahicode.tamaru.reflection;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PerformanceCompare06 {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();//普通式调用：4ms
        test02();//反射式调用：160ms
        test03();//反射式关闭检查调用：64ms
    }

    // 普通调用
    private static void test01() {
        long startTime = System.currentTimeMillis();
        Performance p = new Performance();
        for (int i = 0; i < 100000000; i++) {
            p.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通式调用：" + (endTime - startTime) + "ms");
    }

    // 反射式调用
    private static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long startTime = System.currentTimeMillis();
        Performance p = new Performance();
        Class c1 = Performance.class;
        Method getName = c1.getDeclaredMethod("getName", null);
        for (int i = 0; i < 100000000; i++) {
            getName.invoke(p, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射式调用：" + (endTime - startTime) + "ms");
    }

    // 反射式关闭检查调用
    private static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        long startTime = System.currentTimeMillis();
        Performance p = new Performance();
        Class c1 = Performance.class;
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);//关闭检查
        for (int i = 0; i < 100000000; i++) {
            getName.invoke(p, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射式关闭检查调用：" + (endTime - startTime) + "ms");
    }
}

@Data
class Performance {
    private String name;
}