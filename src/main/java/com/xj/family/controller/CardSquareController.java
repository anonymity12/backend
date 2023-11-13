package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.CardVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.CardSquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    /*

    @GetMapping("/getTop3")


    @GetMapping("/query/{keyword}")

    @PostMapping("/thumbs-up/{cardId}")

    @PostMapping("/send-buy-request/{cardId}")

     */
}
