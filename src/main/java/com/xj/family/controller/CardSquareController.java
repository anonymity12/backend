package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.interceptor.LoginInterceptor;
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

    @GetMapping("/listAll")
    public RespBean listAll() {
        Integer owner = LoginInterceptor.threadLocalUserId.get();
        List<CardVo> allSquareCards = cardSquareService.getAllSquareCards();
        return RespBean.ok("OK", allSquareCards);
    }
    // user wanna buy others card instance, not buy template in the shop
    @GetMapping("/send-buy-request/{cardId}")
    public RespBean sendBuyRequest(@PathVariable("cardId") int cardId) {
        // 1. check user balance


        // 2. check target card price

        // 3. 1<2?:can not buy, return failed; otherwise continue buy

        // 4. sql transaction1: move card to new owner
        // 5. sql transaction2: change two user's balance respectively
        return RespBean.ok("发送购买请求OK");
    }

    /*

    @GetMapping("/getTop3")


    @GetMapping("/query/{keyword}")

    @PostMapping("/thumbs-up/{cardId}")


     */
}
