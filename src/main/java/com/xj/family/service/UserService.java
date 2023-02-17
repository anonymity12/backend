package com.xj.family.service;

import com.xj.family.bean.User;
import com.xj.family.bean.LifeIndicator;
import com.xj.family.bean.dto.ProfileDto;
import com.xj.family.bean.dto.ValidParentDto;
import com.xj.family.bean.vo.LifeIndicatorVo;
import com.xj.family.config.Constants;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.mapper.UserMapper;
import com.xj.family.mapper.UserLifeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public LifeIndicatorVo getUserLifeIndicatorVo(int userId) {
        LifeIndicator indi = userMapper.getUserLifeIndicator(userId);
        System.out.println(">>>>" + indi);
        int dayPassed = indi.getDayPassed();
        int dayAll = indi.getDayAll();
        LifeIndicatorVo vo = new LifeIndicatorVo();
        vo.setDayAll(dayAll);
        vo.setDayPassed(dayPassed);
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

    public ProfileDto getUserProfile(int userId) {
        User user = userMapper.getUserById(userId);
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

    public String headerPictureUpload(MultipartFile file) {
        int userId = LoginInterceptor.threadLocalUserId.get();
        User currentUser = userMapper.getUserById(userId);

        System.out.println("UserService>>>> header picture uploading, file is: " + file);

        String folder = "/home/tt/code/CodeForFamily/backend/img_upload/";
        File imageFolder = new File(folder);
        String imgName = currentUser.getName() + com.xj.family.utils.StringUtils.getRandomString(6)
                + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 5);// -5 for .JPEG like file
        File f = new File(imageFolder, imgName);
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = Constants.SERVER_URL + "/api/img/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}