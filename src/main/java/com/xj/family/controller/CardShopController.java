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
    // todo 1114: im tired at 2023-11-13 22:15:45
}
