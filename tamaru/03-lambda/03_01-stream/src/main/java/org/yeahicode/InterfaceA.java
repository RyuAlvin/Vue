package org.yeahicode;

@FunctionalInterface
public interface InterfaceA {
    void test();
    default void test1() {
        System.out.println("Hello");
    }
}
