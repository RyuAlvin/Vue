package org.yeahicode.tamaru.proxy.jdkproxy;

public class MyTarget implements IMyInterface {
    @Override
    public String run(String str) {
        System.out.println("我使命跑...");
        return "Hello World！" + str;
    }
}
