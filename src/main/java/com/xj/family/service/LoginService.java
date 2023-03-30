/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.service;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.User;
import com.xj.family.bean.dto.LoginDTO;
import com.xj.family.mapper.UserMapper;
import com.xj.family.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: tt
 * @Date: 2023/1/17
 * @Description: author was 三分恶 before;
 * this service provide: 1) login function 2) logout function, maybe later
 **/
@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    public RespBean login(LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getLoginName())){
            return RespBean.error("账号不能为空");
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())){
            return RespBean.error("密码不能为空");
        }
        String username = loginDTO.getLoginName();
        User user  = userMapper.getUserByName(username);

        //比较密码
        if (user !=null && user.getPassword().equals(loginDTO.getPassword())){
            LoginVO loginVO = new LoginVO();
            loginVO.setId(Integer.valueOf(Long.toString(user.getId())));
            String token = UUID.randomUUID().toString().substring(0,8);
            loginVO.setToken(token);
            loginVO.setUser(user);
            saveUserIdIntoRedis(token, user.getId());
            return RespBean.ok("登陆成功",loginVO);
        }
        return RespBean.error("登录失败,密码错误啦！");
    }
    private void saveUserIdIntoRedis(String key, int userId) {
        System.out.println("LoginService.savaUserIdIntoRedis>> key: userId \n" +
                key + ":" + userId);
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, ""+userId, 30, TimeUnit.DAYS);
    }
}
