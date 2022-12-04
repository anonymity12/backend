package com.xj.family.service;

import com.xj.family.mapper.RankMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.lang.Integer;


@Service
public class RankService {
    @Autowired
    RankMapper rankMapper;
    @Autowired
    UserService userService;

    public String getRankForUser(String username) {
        long userId = userService.getUserIdByName(username); 
        // 从 flies 里面 选择所有的 蝴蝶，并依据 owner 来分组
        List<Integer> rankForAllUser = rankMapper.getUserListRanked();
        int yourRank = 9999;
        for (int i = 1; i <= rankForAllUser.size(); i++) {
            if (userId == rankForAllUser.get(i-1)) {
                 yourRank = i;
            }
        }
        return String.valueOf(yourRank);
    }
}
