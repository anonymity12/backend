/*
 * Copyright (c) 2023-01-21 23:02:53 除夕夜  <br> author tt <br>
 */

package com.xj.family.controller;

import com.xj.family.bean.dto.RegisterDTO;
import com.xj.family.result.Result;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.User;
import com.xj.family.service.RegisterService;
import com.xj.family.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
/**
 * 2023-01-21 23:05:20
 **/
@RestController()
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/api/register")
    public RespBean register(@RequestBody RegisterDTO registerDTO) {
        User user = new User();
        user.setCname(registerDTO.getName());
        user.setName(registerDTO.getName());
        user.setBirthday(registerDTO.getBirthday());
        user.setPassword(registerDTO.getPassword());
        RespBean ret = registerService.register(user);
        return ret;
    }
}
