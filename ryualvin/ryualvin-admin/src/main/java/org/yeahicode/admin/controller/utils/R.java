package org.yeahicode.admin.controller.utils;

import lombok.Data;

// 没有 @Data 注解（或手动编写这些方法）时，R 类可能无法正常序列化，导致 Spring 无法将该类转换为所需的 JSON 格式，进而返回 406 Not Acceptable 错误。
@Data
public class R {
    private Integer code;
    private String msg;
    private Object data;

    private R() {
    }

    private R(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static R success(Object data) {
        return new R(Const.SUCCESS_CODE,Const.SUCCESS_MSG,data);
    }

    public static R fail(Integer code, String msg, Object data) {
        return new R(code, msg, data);
    }
}
