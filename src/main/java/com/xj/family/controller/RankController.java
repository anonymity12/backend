package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.RankInfoVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.RankService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.xj.family.config.Constants.RANK_CONTAINER;
import static com.xj.family.config.Constants.RANK_KEY;

@RestController
@CrossOrigin
@RequestMapping("/ranks")
public class RankController {
    @Autowired
    RankService rankService;
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 返回某个用户的排名数字
     *
     * @param name maybe useless after 0204
     * @return
     */
    @GetMapping("/{username}/getMyRank")
    public String getMyRank(@PathVariable("username") String name) {
        return rankService.getRankForUser(name);
    }

    @GetMapping("/getRanksForShow")
    public List<RankInfoVo> getRanksForShow() {
        if (redisTemplate.opsForHash().hasKey(RANK_CONTAINER, RANK_KEY)) {
            Object o = redisTemplate.opsForHash().get(RANK_CONTAINER, RANK_KEY);
            List<RankInfoVo> rankInfoVos = (List<RankInfoVo>) o;
            System.out.println("has cache for ranksForShowHashKey:" + o);

            return rankInfoVos;
        } else {
            List<RankInfoVo> rankForShow = rankService.getRankForShow();
            System.out.println("no cache, now put it in, it is: " + rankForShow);
            redisTemplate.opsForHash().put(RANK_CONTAINER, RANK_KEY, rankForShow);
            redisTemplate.expire(RANK_CONTAINER, 3, TimeUnit.MINUTES);
            return rankForShow;
        }
    }
}
