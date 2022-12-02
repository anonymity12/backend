package com.xj.family.service;

import com.xj.family.mapper.UserMapper;
import com.xj.family.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public Long getUserIdByName(String name) {
        return userMapper.getUserIdByName(name);
    }
    public User getUserInfoByName(String name) {
        return userMapper.getUserByName(name);
    }
}