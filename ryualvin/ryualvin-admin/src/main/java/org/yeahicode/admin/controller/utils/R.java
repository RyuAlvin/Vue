package org.yeahicode.admin.controller.utils;

import lombok.Data;
import org.yeahicode.rbac.result.UserResultEnum;
import org.yeahicode.utility.result.IResultCode;

// 没有 @Data 注解（或手动编写这些方法）时，R 类可能无法正常序列化，导致 Spring 无法将该类转换为所需的 JSON 格式，进而返回 406 Not Acceptable 错误。
@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    private R() {
    }

    private R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R success(T data) {
        return new R(Const.SUCCESS_CODE,Const.SUCCESS_MSG,data);
    }

    @Deprecated
    public static R fail(IResultCode resultCode) {
        return new R(resultCode.getCode(), resultCode.getMsg(), resultCode.getObj());
    }

    public static R fail(UserResultEnum userResultEnum){
        return new R(userResultEnum.getCode(), userResultEnum.getMsg());
    }

    public static R fail(Integer code, String msg){
        return new R(code, msg);
    }
}
