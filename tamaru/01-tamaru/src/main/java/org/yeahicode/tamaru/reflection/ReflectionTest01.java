package org.yeahicode.tamaru.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReflectionTest01 {
    public static void main(String[] args) throws ClassNotFoundException {
        String refence = "org.yeahicode.tamaru.reflection.User";
        Class c1 = Class.forName(refence);
        Class c2 = Class.forName(refence);
        Class c3 = Class.forName(refence);
        System.out.println(c1.hashCode());//385242642
        System.out.println(c2.hashCode());//385242642
        System.out.println(c3.hashCode());//385242642
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    private int age;
    private String name;
}