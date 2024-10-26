package org.yeahicode.admin.controller.utils;

import lombok.Getter;

// 一定要有get方法，不会外部获取不到对应的请求结果代码和信息
@Getter
public enum ResultEnum {

    NO_ADMIN_ERROR(40000, "NO ADMIN !!!"),
    DOWNLOAD_ERROR(50000,"DOWNLOAD ERROR !!!");

    private Integer code;
    private String msg;
    private Object obj;

    private ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
