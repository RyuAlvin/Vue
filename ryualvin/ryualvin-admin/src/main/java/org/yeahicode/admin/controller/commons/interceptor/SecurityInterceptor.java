package org.yeahicode.admin.controller.commons.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.yeahicode.rbac.exeception.UserBusinessException;
import org.yeahicode.rbac.result.UserResultEnum;
import org.yeahicode.utility.threadlocal.UserThreadLocal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该拦截器作为组件注册到容器中
 * 继承的接口HandlerInterceptor中，以下三个都属于默认方法，所以不是强制重写，而是可以选择性重写
 */
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...");
         String token = request.getHeader("token");
         if(StringUtils.isEmpty(token)) {
            throw new UserBusinessException(UserResultEnum.NO_TOKEN_ERROR);
         }
        UserThreadLocal.set(1000);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
        UserThreadLocal.remove();
    }
}
