package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.service.FlyService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FirstPageController {
    @GetMapping(value = "/ping")
    public RespBean hello(){
        return RespBean.ok("pongpong");
    }
}