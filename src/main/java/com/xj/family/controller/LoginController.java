/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.dto.LoginDTO;
import com.xj.family.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2023-01-19 20:40:16
 * 2023-02-26 10:16
 **/
@CrossOrigin
@RestController()
public class LoginController {
    @Autowired
    LoginService loginService;

    /**
     * login with user loginDto(name, passwd)
     * this method is useful when we use front-backend split arch, because we don't use session(cross-origin issue)
     * to track user, we use a token to track user
     * @param loginDTO aka (name, passwd)
     * @return RespBean contains loginVo(token, user bean)
     */
    @PostMapping(value = "/api/login")
    public RespBean login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
