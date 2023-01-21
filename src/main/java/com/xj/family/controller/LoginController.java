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
 * 2023-01-19 20:40:16
 **/
@CrossOrigin
@RestController()
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/api/login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        Result ret = loginService.login(loginDTO);
        // we will not use session anymore, cause cross origin, and front-back split 
        // arch will not support session, so let's use token
        return ret;
	/*
	hashOps = redisTemplate.opsForHMap();	
	hashOps.put(ret.getToken(), ret.getUserInfo());// UserInfo:(at least) contains: name, userId, cname, 
    maybe: use session is enough, for {username, cname, name, userId}
	*/
    }
}
