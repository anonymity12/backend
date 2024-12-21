package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.CardService;
import com.xj.family.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
使用说明：
这个controller 能干嘛？
1. 主页返回用户金币数
2. 减去一些金币（比如 转盘赌博 时候）
 */
@CrossOrigin
@RestController
@RequestMapping("/api/gold")
public class GoldController {
    @Autowired
    GoldService goldService;
    @GetMapping("/queryMine")
    public RespBean queryMine() {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        int userBalance = goldService.getUserBalance(owner);
        return RespBean.ok("OK", userBalance);
    }
    @PostMapping("/decrease")
    public RespBean decreaseMyCoins(@RequestBody Map<String, Integer> body) {
        int owner = LoginInterceptor.threadLocalUserId.get();
        Integer decreaseThisAmountCoins = body.get("goldAmount");
        goldService.subtractGoldForUser(owner, decreaseThisAmountCoins);
        return RespBean.ok("descrease user coins ok");
    }
    @PostMapping("/increase") 
    public RespBean increaseMyGold(@RequestBody Map<String, Integer> body) {
        int owner = LoginInterceptor.threadLocalUserId.get();
        Integer increaseThisAmountCoins = body.get("goldAmount");
        goldService.addGoldForUser(owner, increaseThisAmountCoins);
        return RespBean.ok("increase user coins ok");
    }
}
