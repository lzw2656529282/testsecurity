//package com.example.testsecurity.config;
//
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author: liuzhenwei
// * @date: 2020/10/16
// */
//@Component
//public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Autowired
//    private RedissonClient redissonClient;
//
//    @Override
//    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//        httpServletResponse.setContentType("application/json;charset=UTF-8");
//        httpServletResponse.getWriter().write("未认证处理异常");
//        System.out.println("未认证处理异常");
//        redissonClient.getBucket("111").get();
//    }
//}
