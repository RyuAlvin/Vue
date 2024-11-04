package org.yeahicode.rbac.result;

import lombok.Getter;
import org.yeahicode.utility.result.IResultCode;

// 一定要有get方法，不会外部获取不到对应的请求结果代码和信息
public enum UserResultEnum implements IResultCode {

    NO_ADMIN_ERROR(40000, "NO ADMIN !!!"),
    DOWNLOAD_ERROR(50000,"DOWNLOAD ERROR !!!"),

    ACCESS_EXE_ERROR(60000, "ACCESS EXECEPTION !!!");

    private Integer code;
    private String msg;
    private Object obj;

    private UserResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Object getObj() {
        return obj;
    }
}
