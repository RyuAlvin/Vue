package org.yeahicode.admin.controller.commons;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yeahicode.rbac.exeception.UserBusinessException;
import org.yeahicode.rbac.result.UserResultEnum;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 对所有异常进行捕获
     * 缺点：不明确
     * Throwable
     */
    @ExceptionHandler(Throwable.class)
    public ErrorHandler makeExcepton(Throwable e, HttpServletRequest request) {
        // 1: 一定要加下面这行代码。打印异常堆栈信息，方便程序员去根据异常排查错误 --服务开发者
        e.printStackTrace();
        // 2: 出现异常，统一返回固定的状态---服务用户
        ErrorHandler errorHandler = ErrorHandler.fail(UserResultEnum.NO_ADMIN_ERROR.getCode(),
                UserResultEnum.NO_ADMIN_ERROR.getMsg(), e);
        // 3: 最后返回
        return errorHandler;
    }

    /**
     * 对所有异常进行捕获
     * 缺点：不明确
     * RuntimeException
     */
    @ExceptionHandler(RuntimeException.class)
    public ErrorHandler makeExcepton2(RuntimeException e, HttpServletRequest request) {
        // 1: 一定要加下面这行代码。打印异常堆栈信息，方便程序员去根据异常排查错误 --服务开发者
        e.printStackTrace();
        // 2: 出现异常，统一返回固定的状态---服务用户
        ErrorHandler errorHandler = ErrorHandler.fail(UserResultEnum.ACCESS_EXE_ERROR.getCode(),
                UserResultEnum.ACCESS_EXE_ERROR.getMsg(), e);
        // 3: 最后返回
        return errorHandler;
    }

    /**
     * 自定义异常捕获
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(UserBusinessException.class)
    public ErrorHandler makeUserBusinessException(UserBusinessException e, HttpServletRequest request) {
        // 1: 一定要加下面这行代码。打印异常堆栈信息，方便程序员去根据异常排查错误 --服务开发者
        e.printStackTrace();
        // 2: 出现异常，统一返回固定的状态---服务用户
        ErrorHandler errorHandler = ErrorHandler.fail(e.getCode(), e.getMessage(), e);
        // 3: 最后返回
        return errorHandler;
    }
}