package com.xj.family.service;

import com.xj.family.mapper.UserMapper;
import com.xj.family.bean.User;
import com.xj.family.bean.dto.ValidParentDto;

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

    public boolean validParent(ValidParentDto item) {
        if (item.getParent_passwd().equals("2023")) {
            return true;
        }
        return false;
    }
}