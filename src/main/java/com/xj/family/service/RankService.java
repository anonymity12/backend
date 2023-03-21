package com.xj.family.service;

import com.xj.family.bean.User;
import com.xj.family.bean.vo.RankInfoVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.mapper.RankMapper;

import com.xj.family.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;


@Service
public class RankService {
    @Autowired
    RankMapper rankMapper;
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    // 0321 changelog: now return the bottom rank number by the Grow Cnt(aka finished tasks number); not total count anymore
    public String getRankForUser(String username) {
        long userId = userService.getUserIdByName(username); 
        // will return an int list(userIds), ordered by their finished tasks count;
        List<Integer> rankForAllUser = rankMapper.getUserListRankedByGrowCnt();
        int yourRank = 9999;
        for (int i = 1; i <= rankForAllUser.size(); i++) {
            if (userId == rankForAllUser.get(i-1)) {
                 yourRank = i;
            }
        }
        return String.valueOf(yourRank);
    }
    public List<RankInfoVo> getRankForShow() {
        System.out.println("in rank service");
        List<RankInfoVo> rankInfoVos = rankMapper.getUserListRankedWithFliesCnt();
        return rankInfoVos;
    }
}
