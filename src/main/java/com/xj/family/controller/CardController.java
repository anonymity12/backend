package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
使用说明：
这个controller 能干嘛？
1. 在card画廊界面  user will determine which is the main card to refine；❌ not support yet at 1122;
2. 在gww主页界面 refine the card: upgrade or downgrade;(1028, do we really support downgrade? and how?)✅ 已经与task控制器联动了
3. 在card画廊界面 展示出所有我的卡片 ⭕️还没实现 前端的  card画廊界面
4。在gww主页界面   展示每个用户的主卡片 ✅
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


    // 某个用户面对自己的card 画廊，要卖card，点击出售按钮，让某个card变为可出售的
    @PostMapping("/sellCard")
    public RespBean markCardSellable(@RequestParam int cardInstanceId) {
        cardService.markCardSellable(cardInstanceId);// TODO: 2023/11/22  use it's ret
        return RespBean.ok("标记卡片为出售状态");
    }
    // 用户标记某个card为不出售，他/她 可能反悔了这个出售操作
    @PostMapping("/unsellCard")
    public RespBean markCardUnsellable(@RequestParam int cardInstanceId) {
        cardService.markCardUnsellable(cardInstanceId);// TODO: 2023/11/22  use it's ret
        return RespBean.ok("标记卡片为储藏状态");
    }
}
