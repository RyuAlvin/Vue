package org.yeahicode.admin.controller.commons;

import lombok.Data;

/**
 * 为什么定义这个类，不直接使用R类，因为不用污染R类，保持单一性
 */
@Data
public class ErrorHandler {
    // 异常的状态码，从枚举中获得
    private Integer code;
    // 异常的消息，写用户看得懂的异常，从枚举中得到
    private String message;
    // 异常的名字
    private String exception;


    public static ErrorHandler fail(Integer code,String message, Throwable throwable) {
        ErrorHandler errorHandler = new ErrorHandler();
        errorHandler.setMessage(message);
        errorHandler.setCode(code);
        errorHandler.setException(throwable.getClass().getName());
        return errorHandler;
    }
}
