package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.CardService;
import com.xj.family.service.CardSquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/card-square")
public class CardSquareController {
    @Autowired
    CardSquareService cardSquareService;
    @Autowired
    CardService cardService;

    @GetMapping("/listAll")
    public RespBean listAll() {
        List<CardVo> allSquareCards = cardSquareService.getAllSquareCards();
        return RespBean.ok("OK", allSquareCards);
    }

    @PostMapping("/tradeCard")
    public RespBean tradeCard(@RequestParam int cardInstanceId) {
        int cardOwner = cardService.getCardOwner(cardInstanceId);
        Integer me = LoginInterceptor.threadLocalUserId.get();
        cardSquareService.tradeCard(cardInstanceId, cardOwner, me);
        return null;
    }


}
    /*
卡片广场最核心支持的是：
    列出所有卡片
    交易卡片

    @GetMapping("/getTop3")


    @GetMapping("/query/{keyword}")

    @PostMapping("/thumbs-up/{cardId}")


     */
//  或许这是拍卖的场景，后续实现，用户可以通过拍卖，进行聊天。为何可以拍卖？因为NFT是前车可参考
    /*@GetMapping("/send-buy-request/{cardId}")
    public RespBean sendBuyRequest(@PathVariable("cardId") int cardId) {
        // 1. check user balance


        // 2. check target card price

        // 3. 1<2?:can not buy, return failed; otherwise continue buy

        // 4. sql transaction1: move card to new owner
        // 5. sql transaction2: change two user's balance respectively
        return RespBean.ok("发送购买请求OK");
    }

     */
