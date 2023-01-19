/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.service;

import com.xj.family.dto.LoginDTO;
import com.xj.family.bean.User;
import com.xj.family.mapper.UserMapper;
import com.xj.family.result.Result;
import com.xj.family.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * @Author: 三分恶
 * @Date: 2021/1/17
 * @Description:
 **/
@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate template;

    public Result login(LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getLoginName())){
            return new Result(400,"账号不能为空","");
        }
        if (StringUtils.isEmpty(loginDTO.getPassword())){
            return new Result(400,"密码不能为空","");
        }
        String username = loginDTO.getLoginName();
        User user  = userMapper.getUserByName(username);
        //比较密码
        if (user !=null && user.getPassword().equals(loginDTO.getPassword())){
            LoginVO loginVO = new LoginVO();
            loginVO.setId(Integer.valueOf(Long.toString(user.getId())));
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            String token = UUID.randomUUID().toString();
            loginVO.setToken(token);
            loginVO.setUser(user);
            
            saveTokenIntoRedis(token, user);
            return new Result(200,"",loginVO);
        }
        return new Result(401,"登录失败","");
    }
    private void saveTokenIntoRedis(String token, User user) {
        HashOperations<String, Object, Object> hashOperations =
                template.opsForHash();
        hashOperations.put("loggedInUser", token, user.getName());
    }
}
