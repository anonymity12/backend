package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;

    // user buy the basic shop card with his/her gold
    @PostMapping("/buyNewCard")
    public RespBean buyNewCard(@RequestParam int cardTemplateId) {
        return null;
    }

    // user buy other user's card with his/her gold
    @PostMapping("/tradeCard")
    public RespBean tradeCard(@RequestParam int cardInstanceId) {
        return null;
    }
}
