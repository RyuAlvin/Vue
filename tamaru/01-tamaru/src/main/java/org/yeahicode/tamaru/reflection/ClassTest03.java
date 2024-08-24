package org.yeahicode.tamaru.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.ElementType;

public class ClassTest03 {
    public static void main(String[] args) {
        Class c1 = Sports.class;//class org.yeahicode.tamaru.reflection.Sports
        Class c2 = Comparable.class;//interface java.lang.Comparable
        Class c3 = int[].class;//class [I
        Class c4 = int[][].class;//class [[I
        Class c5 = ElementType.class;//class java.lang.annotation.ElementType
        Class c6 = Override.class;//interface java.lang.Override
        Class c7 = int.class;//int
        Class c8 = void.class;//void
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Sports {
    String name;
}
