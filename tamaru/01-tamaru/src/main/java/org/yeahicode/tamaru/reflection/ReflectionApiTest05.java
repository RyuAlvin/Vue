package org.yeahicode.tamaru.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReflectionApiTest05 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("org.yeahicode.tamaru.reflection.Product");
//        Arrays.stream(c1.getFields()).forEach(field -> {
//            System.out.println(field.getName()); // 本类+父类+接口 的public字段（接口中的成员变量默认为public）
//        });
//        System.out.println("========================");

//        Arrays.stream(c1.getDeclaredFields()).forEach(field -> {
//            System.out.println(field.getName()); // 本类 的所有字段
//        });
//        System.out.println("========================");

//        Arrays.stream(c1.getMethods()).forEach(method -> {
//            System.out.println(method.getName()); // 本类+父类+接口 中的public方法
//        });
//        System.out.println("========================");

//        Arrays.stream(c1.getDeclaredMethods()).forEach(method -> {
//            System.out.println(method.getName()); // 本类 中的所有方法
//        });
//        System.out.println("========================");

//        Arrays.stream(c1.getConstructors()).forEach(c -> {
//            System.out.println(c.getName() + "$$$" + c.getParameterTypes().length); // 本类 中的public构造函数
//        });
//        System.out.println("========================");

//        Arrays.stream(c1.getDeclaredConstructors()).forEach(c -> {
//            System.out.println(c.getName() + "$$$" + c.getParameterTypes().length); // 本类 中的所有构造函数
//        });
//        System.out.println("========================");

//        Class superclass = c1.getSuperclass(); // 获取父类
//        Class[] interfaces = c1.getInterfaces(); // 获取所有继承接口
//        System.out.println("========================");

//        Class aa = AA.class;
//        Object o = aa.newInstance(); // 类必须拥有无参构造函数，否则报错
//        System.out.println("========================");

//        Object product = c1.newInstance();
//        Method test02 = c1.getDeclaredMethod("test02", String.class);
//        test02.setAccessible(true); // 调用private方法前需要设置可访问，否则报错
//        String returnStr = (String)test02.invoke(product, "Hello World"); // 方法调用，传入实例+参数
//        System.out.println(returnStr);
//        System.out.println("========================");

//        Method test03 = c1.getDeclaredMethod("test03", List.class);
//        Arrays.stream(test03.getGenericParameterTypes()).forEach(param->{
//            if(param instanceof ParameterizedType) {
//                Arrays.stream(((ParameterizedType) param).getActualTypeArguments()).forEach(x->{
//                    System.out.println("$$$$$$$$$$ " + x.getTypeName());
//                });
//            }
//        });
//        System.out.println("========================");

        Method test03 = c1.getDeclaredMethod("test03", List.class);
        Type returnType = test03.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            Arrays.stream(((ParameterizedType) returnType).getActualTypeArguments()).forEach(x -> {
                System.out.println(x.getTypeName());
                if (x instanceof ParameterizedType) {
                    Arrays.stream(((ParameterizedType) x).getActualTypeArguments()).forEach(y -> {
                        System.out.println(y.getTypeName());
                    });
                }
            });
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class AA {
    String name;
}

class Product extends Factory implements FactoryInterface {

    public Product() {
    }

    public Product(String id, String name, Double store) {
        this.id = id;
        this.name = name;
        this.store = store;
    }

    String id;
    String name;
    Double store;

    public String address;

    public void test01(String name) {

    }

    private String test02(String name) {
        return name;
    }

    public Map<String, List<Person>> test03(List<String> list) {
        return null;
    }

    @Override
    public void create() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getStore() {
        return store;
    }

    public void setStore(Double store) {
        this.store = store;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

interface FactoryInterface {
    void create();

    String msg = "Hello World!";
}

class Factory {
    public String factoryName;

    private void superA() {

    }

    public void publicSuperA() {

    }

    public Factory() {
    }

    public Factory(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }
}