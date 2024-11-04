package org.yeahicode.rbac.exeception;

import lombok.Data;
import org.yeahicode.utility.result.IResultCode;

@Data
public class UserBusinessException extends RuntimeException {
    // 异常的状态码，从枚举中获得
    private Integer code;
    // 异常的消息，写用户看得懂的异常，从枚举中得到
    private String msg;

    public UserBusinessException(IResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
}
