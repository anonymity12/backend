package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.service.RankService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ranks")
public class RankController {
    @Autowired
    RankService rankService;

    @GetMapping("/{username}/getMyRank")
    public String getFlies(@PathVariable("username") String name) {
        return rankService.getRankForUser(name);
    }
}
