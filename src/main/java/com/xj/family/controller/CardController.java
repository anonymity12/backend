package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
user can use such controller to:
1. buy new card from the shop, so they can start refine it by finish daily tasks
2. they can trade card with each other
    by default, trading also happen in shop page
    but buy is first row, and trading is later rows
3. user will determine which is the main card to refine
4. refine the card: upgrade or downgrade
 */

@CrossOrigin
@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping("/listAllMyCard")
    public RespBean listAllMyCard() {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        List<CardVo> allMyCards = cardService.getAllMyCards(owner);
        return RespBean.ok("OK", allMyCards);
    }

    @GetMapping("/getMyMainCard")
    public RespBean getMyMainCard() {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        CardVo card = cardService.getMyMainCard(owner);
        return RespBean.ok("OK", card);
    }


    // user buy the basic shop card with his/her gold
    @PostMapping("/buyNewCard")
    public RespBean buyNewCard(@RequestParam int cardTemplateId) {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        cardService.createCardInstance(owner, cardTemplateId);
        return null;
    }

    // user buy other user's card with his/her gold, in the plaza/market
    @PostMapping("/tradeCard")
    public RespBean tradeCard(@RequestParam int cardInstanceId) {
        int cardOwner = cardService.getCardOwner(cardInstanceId);
        Integer me = LoginInterceptor.threadLocalUserId.get();
        cardService.tradeCard(cardInstanceId, cardOwner, me);
        return null;
    }

    //
    @PostMapping("/determineMainCard")
    public RespBean determineMainCard(@RequestParam int cardInstanceId) {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        cardService.setMainCard(owner, cardInstanceId);
        return null;
    }

    @PostMapping("/upgradeCard")
    public RespBean upgradeCard() {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        cardService.upgradeCard(owner);
        return null;
    }

    @PostMapping("/downgradeCard")
    public RespBean downgradeCard(@RequestParam int cardInstanceId) {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        cardService.downgradeCard(owner);
        return null;
    }
}
