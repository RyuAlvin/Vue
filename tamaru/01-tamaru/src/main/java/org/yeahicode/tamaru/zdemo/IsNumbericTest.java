package org.yeahicode.tamaru.zdemo;

import java.util.regex.Pattern;

public class IsNumbericTest {
    public static void main(String[] args) {
        boolean regex = regex("000000103");
        System.out.println(regex);
    }

    private static boolean regex(String str) {
        String regex = "^-?[0-9]*(\\.\\d+)?$";
//        String regex = "^[0]*(\\d+)?$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
}
