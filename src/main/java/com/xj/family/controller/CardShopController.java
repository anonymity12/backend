package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.CardShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/card-shop")
public class CardShopController {

    @Autowired
    CardShopService cardShopService;

    // user buy the basic shop card with his/her gold
    @PostMapping("/buyNewCard")
    public RespBean buyNewCard(@RequestParam int cardTemplateId) {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        int status = cardShopService.buyANewCard(owner, cardTemplateId);
        // return based on the status
        return null;
    }

    // users will see all the sellable cards on the shop
    // these cards could come from users who sell their card
    // or from the system setting, or activity
    @GetMapping("/getAllSellCards")
    public RespBean getAllSellCards() {
        List<CardVo> allSellCards = cardShopService.getAllSellCards();
        return RespBean.ok("ok", allSellCards);
    }

    // card lottery
    // tdo 1114: im tired at 2023-11-13 22:15:45
    @PostMapping("/cardLottery")
    public RespBean cardLottery() {
        // 1. get user id
        // 2. get card numbers: randomLimit
        // 3. generate random number: lotteryNum; from 1 to randomLimit
        // 4. write sql: insert a new card instance record for card tbl, and that card belongs to this user
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        // tt>>> todo 2023-11-15 23:05:20; time to sleep, it's cold outside, especially u went out for a moto drive with newly meet friend;
        return RespBean.ok("抽奖完成");
    }
}
