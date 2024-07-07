/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xj.family.bean.RespBean;
import com.xj.family.util.HttpContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * 2023-01-19 20:40:49
 * check before each handle, make sure user have already logged in
 * now(0201) we gradually migrate to using simple string
 *  aka token:userId in redis(instead of hash)
 *  2024 07 07 19:40 add logger from slf4j(log4j as backend)
 **/
public class LoginInterceptor implements HandlerInterceptor {
    public static ThreadLocal<Integer> threadLocalUserId = new ThreadLocal<>();
    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        log.info("login interceptor intercepted this method:" + handler);
        // fix OPTIONS 预检请求不成功, CORS preflight failed
        // https://blog.csdn.net/m0_46269959/article/details/125098405
        if (request.getMethod().equals("OPTIONS")) {
            log.info("origin url: " + HttpContextUtil.getOrigin());
            response.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
            response.setHeader("Access-Control-Allow-Headers", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            setReturn(response, "user not login, plz login first");
            return false;
        }

        /*
        in redis:
        we use string data structure
        key   | string
        token | userId
        ------|-------
        y7u9i | 16
        nh891 | 2
         */
        log.info("get userId for token: " + token + " from redis now");
        // 2023-04-17 23:09:01 fix error: when no such token, Integer.valueOf(null) will throws:java.lang.NumberFormatException
        String userIdString = redisTemplate.opsForValue().get(token);
        if (userIdString == null) {
            setReturn(response, "token is invalid or out-of-date");
            return false;
        }
        int userId = Integer.parseInt(userIdString);
        log.info("user " + userId + " is active");
        threadLocalUserId.set(userId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }

    //返回json格式错误信息
    private static void setReturn(HttpServletResponse response, String msg) throws IOException {
        log.error("loginInterceptor find error in token, and msg is: " + msg);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(401);
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        httpResponse.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(RespBean.invalidToken(msg));
        httpResponse.getWriter().print(json);
        log.warn("done send json to frontend, json: " + json);
    }
}
