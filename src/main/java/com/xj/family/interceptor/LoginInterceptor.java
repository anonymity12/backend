/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xj.family.bean.RespBean;
import com.xj.family.util.HttpContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;



/**
 * 2023-01-19 20:40:49
 * check before each handle, make sure user have already logged in
 * now(0201) we gradually migrate to using simple string
 *  aka token:userId in redis(instead of hash)
 **/
public class LoginInterceptor implements HandlerInterceptor {
    public static ThreadLocal<Integer> threadLocalUserId = new ThreadLocal<>();
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("\t\tlogin interceptor intercepted:" + handler);
        // fix OPTIONS 预检请求不成功, cors preflight failed
        // https://blog.csdn.net/m0_46269959/article/details/125098405
        if (request.getMethod().equals("OPTIONS")) {
            System.out.println("origin url: " + HttpContextUtil.getOrigin());
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
            setReturn(response,400,"用户未登录，请先登录");
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
        System.out.println("\n >>> ready to get loggedUser Id for token" + token);
        // 2023-04-17 23:09:01 fix error: when no such token, Integer.valueOf(null) will throws:java.lang.NumberFormatException
        String userIdString = redisTemplate.opsForValue().get(token);
        if (userIdString == null) {
            setReturn(response,25014250,"用户token已过期，或者无效token");
            return false;
        }
        int userId = Integer.parseInt(userIdString);
        System.out.println("now, user: " + userId + "is active");
        // 2023-04-17 23:16:07 fix done;
        threadLocalUserId.set(userId);
        return true;
    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    //返回json格式错误信息
    private static void setReturn(HttpServletResponse response, Integer code, String msg) throws IOException {
        System.out.println("error: not login");
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());
        //UTF-8编码
        httpResponse.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(RespBean.error(msg));
        httpResponse.getWriter().print(json);
        System.out.println("error: return will");
    }
}
