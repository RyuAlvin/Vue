package org.yeahicode.tamaru.zdemo;


import java.util.HashSet;
import java.util.Set;

public class LeecodeDemo {
    public static void main(String[] args) {
//        System.out.println((char)48); // 0
//        System.out.println((char)57); // 9
//        int smallA = 97;
//        int smallZ = 122;
//        int bigA = 65;
//        int bigZ = 90;
        String word = "a1b01c001";
        int i = numDifferentIntegers(word);
        System.out.println(i);
    }

    private static int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        Set<String> set = new HashSet<>();
        String temp = "";
        for (int i = 0; i < chars.length; i++) {
            if ((int) chars[i] >= 48 && (int) chars[i] <= 57) {
                temp += chars[i];
                if (i == word.length() - 1) {
                    set.add(temp);
                    temp = "";
                }
            } else {
                if (!"".equals(temp)) {
                    set.add(temp);
                    temp = "";
                }
            }
        }
        return set.size();
    }
}
