package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.CardService;
import com.xj.family.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
使用说明：
这个controller 能干嘛？
1. 主页返回用户金币数
 */
@CrossOrigin
@RestController
@RequestMapping("/api/gold")
public class GoldController {
    // /api/gold/queryMine
    @Autowired
    GoldService goldService;
    @GetMapping("/queryMine")
    public RespBean queryMine() {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        int userBalance = goldService.getUserBalance(owner);
        return RespBean.ok("OK", userBalance);
    }
}
