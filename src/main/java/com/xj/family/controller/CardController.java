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
    but buy is first row, and trading is later rows；and trading is low priority feat, we'll finish at Dec
3. user will determine which is the main card to refine
4. refine the card: upgrade or downgrade;(1028, do we really support downgrade? and how?)
 */

@CrossOrigin
@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;

    /************************* basic feat: list, query, update ***************************/

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
    @PostMapping("/upgradeCard")
    public RespBean upgradeCard() {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        cardService.upgradeCard(owner);
        return null;
    }
    // for now 1028, we'll not use this api-endpoint
    // because it only will be used when punishment is achieved
    // might achieve at Nov
    // guess achieve is also a stimulation for gww users
    @PostMapping("/downgradeCard")
    public RespBean downgradeCard(@RequestParam int cardInstanceId) {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        cardService.downgradeCard(owner);
        return null;
    }
    // for now 1028, we'll not support this feat; we'll support till the shop page
    // is online, guess is the Nov thing
    // for now 1028, we manually set the main card for each user
    // and in Nov, we'll collect more cards, so we can make the shop exist
    // then: determine main card, or trade card will be good to go
    @PostMapping("/determineMainCard")
    public RespBean determineMainCard(@RequestParam int cardInstanceId) {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        cardService.setMainCard(owner, cardInstanceId);
        return null;
    }

    /************************* adv feat: trading(will finish at Nov) ***************************/

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
}
