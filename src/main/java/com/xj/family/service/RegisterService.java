/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.service;

import com.xj.family.bean.User;
import com.xj.family.mapper.UserMapper;
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
 * @Date: 2023/1/21; 2024/6/27
 * @Description: 注册
 **/
@Service
public class RegisterService {
    public static final int ERR_NAME_EMPTY = -1;
    public static final int ERR_PASSWORD_EMPTY = -2;
    public static final int ERR_NAME_REPEAT = -3;
    public static final int ERR_UNKNOWN = -4;
    public static final int ERR_DB_INSERT = -5;
    public static final int ERR_NAME_TOO_SHORT = -6;
    @Autowired
    private UserMapper userMapper;

    public int register(User user) {
        if (StringUtils.isEmpty(user.getName())){
            return ERR_NAME_EMPTY;
        }
        if (StringUtils.isEmpty(user.getPassword())){
            return ERR_PASSWORD_EMPTY;
        }
        if (user.getName().length() < 5) {
            return ERR_NAME_TOO_SHORT;
        }
        User me = userMapper.getUserByName(user.getName());
        if (me != null) {
            return ERR_NAME_REPEAT;
        }
        int opsCount = userMapper.addNewUser(user);
        if (opsCount <= 0) {
            return ERR_DB_INSERT;
        }
        System.out.println("will mysql return ai key?: "+user.getId());
        if (opsCount > 0) 
            return user.getId();
        else 
            return ERR_UNKNOWN;
    }
}