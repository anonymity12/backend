package com.xj.family.controller;

import com.xj.family.bean.User;
import com.xj.family.bean.RespBean;
import com.xj.family.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{username}/getInfo")
    public User getInfo(@PathVariable("username") String name) {
        return userService.getUserInfoByName(name);
    }

    @PostMapping("/validParent")
    public RespBean validParent(@RequestBody ValidParam item) {
        if (userService.validParent(item)) { // todo : validParent 2022-12-10 14:47:46
            return RespBean.ok("验证通过");
        } else {
            return RespBean.error("验证不通过");
        }
    }
}
