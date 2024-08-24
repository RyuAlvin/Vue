package org.yeahicode.tamaru.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class GetClassWay02 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1、通过实例获取Class对象
        Person student = new Student();//父类的引用指向子类的实例
        student.setName("ryu");
        student.setAge(20);
        Class c1 = student.getClass();
        System.out.println("通过实例获取Class对象 ---> " + c1.hashCode());//824009085
        // 2、通过类名获取Class对象
        Class c2 = Person.class;
        System.out.println("通过父类名获取Class对象 ---> " + c2.hashCode());//385242642
        Class c3 = Student.class;
        System.out.println("通过子类名获取Class对象 ---> " + c3.hashCode());//824009085
        // 3、通过包名获取Class对象
        Class c4 = Class.forName("org.yeahicode.tamaru.reflection.Person");//385242642
        System.out.println("通过父类包名获取Class对象 ---> " + c4.hashCode());
        Class c5 = Class.forName("org.yeahicode.tamaru.reflection.Student");//824009085
        System.out.println("通过子类包名获取Class对象 ---> " + c5.hashCode());//824009085
        // 4、通过子类获取父类Class对象
        Class c6 = c1.getSuperclass();
        System.out.println("通过子类获取父类的Class对象 ---> " + c6.hashCode());//385242642
        // 5、通过基本内置类型的包装类获取Class对象
        Class<Integer> integerType = Integer.TYPE;
        System.out.println("通过基本内置类型的包装类获取Class对象 ---> " + integerType.hashCode());//2085857771
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    String name;
    int age;
}

@Data
class Student extends Person {
}
