/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xj.family.result.Result;
import com.xj.family.util.HttpContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 2023-01-19 20:40:49
 * check before each handle, make sure user have already logged in
 **/

public class LoginInterceptor implements HandlerInterceptor {
    public static ThreadLocal<String> threadLocalUsername = new ThreadLocal<>();

    @Autowired
    private StringRedisTemplate template;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //从header中获取token
        String token = request.getHeader("token");
        //如果token为空
        if (StringUtils.isEmpty(token)) {
            setReturn(response,400,"用户未登录，请先登录");
            return false;
        }
        //在实际使用中还会:
        // 1、校验token是否能够解密出用户信息来获取访问者
            // we may retrive use from redis by this token
            // and then we might save use in threadLocal or somethin
        // 2、token是否已经过期
        // use redis to check user
        
        /*
        *	user = redisTemplate.opsForValue(token, 0);
        *      threadLocalUser.set(user);
        * */
        HashOperations<String, Object, Object> hashOperations =
                template.opsForHash();
        String username = (String)hashOperations.get("loggedInUser", token);
        threadLocalUsername.set(username);
        return true;
    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    //返回json格式错误信息
    private static void setReturn(HttpServletResponse response, Integer code, String msg) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        //UTF-8编码
        httpResponse.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        Result result = new Result(code,msg,"");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        httpResponse.getWriter().print(json);
    }

}
