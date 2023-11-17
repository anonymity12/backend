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
    @GetMapping("/buyNewCard")
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

    @PostMapping("/cardLottery")
    public RespBean cardLottery() {
        Integer userId = LoginInterceptor.threadLocalUserId.get();
        cardShopService.makeCardLotteryForUser(userId);
        // tt>>> time to pao foot 2023-11-16 23:25:07
        // tt>>> tdo 2023-11-15 23:05:20; time to sleep, it's cold outside, especially u went out for a moto drive with newly meet friend;
        return RespBean.ok("抽奖完成");
    }
}
