package org.yeahicode.tamaru.zdemo;

import java.util.ArrayList;
import java.util.Vector;

public class NullTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("1");
        user.setAge(1);
        if (user.getAge() != null && user.getAge().equals(1)) {
            System.out.println("1111");
        }
        if (user.getName() != null && user.getName().equals("1")) {
            System.out.println("2222");
        }

    }
}
