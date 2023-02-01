package com.xj.family.service;

import com.xj.family.bean.User;
import com.xj.family.bean.LifeIndicator;
import com.xj.family.bean.dto.ProfileDto;
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

    public ProfileDto getUserProfile(String username) {
        User user = userMapper.getUserByName(username);
        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(user.getId());
        profileDto.setIntro(user.getIntro());
        profileDto.setCosmosId(user.getName());
        profileDto.setName(user.getCname());
        profileDto.setPassword(user.getPassword());
        profileDto.setUserface(user.getUserface());
        profileDto.setBirthday(user.getBirthday());


        return profileDto;
    }

    public int updateUserProfile(ProfileDto profileDto) {
        // // 1) update table: user_life_start_end_table
        // Calendar a = Calendar.getInstance();
        // a.setTime(profileDto.getBirthday());
        // a.add(Calendar.YEAR, 100); // maybe later we can input custom year
        // Date end = new Date(a.getTimeInMillis());
        // userLifeMapper.setLifeStartAndEnd(profileDto.getId(), profileDto.getBirthday(), end);
        // close 1), because sql error: cannot insert into user_life_start_end_table again
        //    we must update, so wait for future todo(in the future, guess,we dont need the user_life_start_end_table anymore)
        // 2) update table: user
        return userMapper.updateUserProfile(profileDto);
    }
}