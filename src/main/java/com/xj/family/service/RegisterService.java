/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.service;

import com.xj.family.bean.User;
import com.xj.family.mapper.UserMapper;
import com.xj.family.result.Result;
import com.xj.family.bean.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * @Author: zrt
 * @Date: 2023/1/21
 * @Description: 注册
 **/
@Service
public class RegisterService {
    @Autowired
    private UserMapper userMapper;

    public RespBean register(User user) {
        if (StringUtils.isEmpty(user.getName())){
            return new RespBean(400,"名字不能为空","");
        }
        if (StringUtils.isEmpty(user.getPassword())){
            return new RespBean(400,"密码不能为空","");
        }
        User me = userMapper.getUserByName(user.getName());
        if (me != null) {
            return new RespBean(400,"用户已经注册了","");
        }
        if (1 == userMapper.addNewUser(user)) 
            return RespBean.ok("用户注册成功");
        else 
            return RespBean.error("用户注册失败");
    }
}