/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.controller;

import com.xj.family.dto.LoginDTO;
import com.xj.family.result.Result;
import com.xj.family.service.LoginService;
import com.xj.family.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 三分恶
 * @Date: 2021/1/17
 * @Description: TODO
 **/
@RestController()
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/api/login")
    public Result login(@RequestBody LoginDTO loginDTO, HttpSession session) {
        Result ret = loginService.login(loginDTO);
        if (ret.getCode() != 200) {
            // wrong in login service, so just return 
            return ret;
        } else {
            // this session attr contain whole loginVo{id, token, User}
            session.setAttribute(Constants.LOGIN_USER, ret.getData());
            return ret;
        }
        
	/*
	hashOps = redisTemplate.opsForHMap();	
	hashOps.put(ret.getToken(), ret.getUserInfo());// UserInfo:(at least) contains: name, userId, cname, 
    maybe: use session is enough, for {username, cname, name, userId}
	*/
    }
}
