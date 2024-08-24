package org.yeahicode.httpclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yeahicode.httpclient.entity.UserRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Controller
public class UserController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(UserRequest userRequest, HttpServletRequest httpServletRequest) {
        System.out.println("业务入参：" + userRequest);
        // 获取所有请求头
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ":" + httpServletRequest.getHeader(headerName));
        }
        return "test1";
    }

    @PostMapping(value = "/test2")
    @ResponseBody
    public String test2(UserRequest userRequest, HttpServletRequest httpServletRequest) {
        System.out.println("业务入参：" + userRequest);
        // 获取所有请求头
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ":" + httpServletRequest.getHeader(headerName));
        }
        return "test2";
    }

    @PostMapping(value = "/testJson")
    @ResponseBody
    public String testJson(@RequestBody UserRequest userRequest, HttpServletRequest httpServletRequest) {
        System.out.println("业务入参：" + userRequest);
        // 获取所有请求头
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ":" + httpServletRequest.getHeader(headerName));
        }
        return "testJson";
    }

    @PostMapping(value = "/testUpload")
    @ResponseBody
    public String testJson(@RequestParam("file") MultipartFile[] files, UserRequest userRequest, HttpServletRequest httpServletRequest) {
        Arrays.stream(files).forEach(x -> System.out.println("文件名：" + x.getOriginalFilename()));
        System.out.println("其他业务入参：username=" + userRequest.getUsername());
        System.out.println("其他业务入参：password=" + userRequest.getPassword());
        // 获取所有请求头
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ":" + httpServletRequest.getHeader(headerName));
        }
        return "testUpload";
    }
}
