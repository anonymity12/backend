package com.xj.family.service;

import com.xj.family.bean.User;
import com.xj.family.bean.LifeIndicator;
import com.xj.family.bean.dto.ValidParentDto;
import com.xj.family.bean.vo.LifeIndicatorVo;
import com.xj.family.mapper.UserMapper;

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

    public LifeIndicatorVo getUserLifeIndicatorVo() {
        // todo find out user identity(with threadLocal??)
        Long userId = 1L; // for now 1227, always tt;
        LifeIndicator indi = userMapper.getUserLifeIndicator(userId);
        int dayPassed = indi.getDayPassed();
        int dayAll = indi.getDayAll();
        LifeIndicatorVo vo = new LifeIndicatorVo();
        vo.setDayAll(dayAll);
        vo.setDayPassed(dayPassed);
        vo.setUserId(userId);
        return vo;
    }
}