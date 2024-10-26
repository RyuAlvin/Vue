package org.yeahicode.admin.controller.utils;

// 也可将常量类定义成接口，接口中的变量默认都是public static final修饰，即全局常量
public interface Const {
    Integer SUCCESS_CODE = 20000;
    String SUCCESS_MSG = "访问成功";

    Integer NO_ADMIN_CODE = 40000;
    String NO_ADMIN_MSG = "NO ADMIN !!!";
}
