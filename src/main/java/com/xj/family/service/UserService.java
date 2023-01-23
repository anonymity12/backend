package com.xj.family.service;

import com.xj.family.bean.User;
import com.xj.family.bean.LifeIndicator;
import com.xj.family.bean.dto.ValidParentDto;
import com.xj.family.bean.vo.LifeIndicatorVo;
import com.xj.family.mapper.UserMapper;
import com.xj.family.mapper.UserLifeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Calendar;
import java.sql.Date;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserLifeMapper userLifeMapper;

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

    public LifeIndicatorVo getUserLifeIndicatorVo(String username) {
        Long userId = userMapper.getUserIdByName(username);
        System.out.println("get userId for username " + username + " id: " + userId);
        LifeIndicator indi = userMapper.getUserLifeIndicator(userId);
        System.out.println(">>>>" + indi);
        int dayPassed = indi.getDayPassed();
        int dayAll = indi.getDayAll();
        LifeIndicatorVo vo = new LifeIndicatorVo();
        vo.setDayAll(dayAll);
        vo.setDayPassed(dayPassed);
        vo.setUsername(username);
        return vo;
    }
    // when user register, give them a default life end, aka birthday + 100 years
    public int setDefaultLifeStartAndEnd(int userId, Date start) {
        Calendar a = Calendar.getInstance();
        a.setTime(start);
        a.add(Calendar.YEAR, 100);
        Date end = new Date(a.getTimeInMillis());
        return userLifeMapper.setLifeStartAndEnd(userId, start, end);
    }
}