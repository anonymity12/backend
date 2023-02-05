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
    public List<RankInfoVo> getRankForShow() {
        List<Integer> userIdsByRank = rankMapper.getUserListRanked();
        List<RankInfoVo> rankInfoVos = new ArrayList<>();
        userIdsByRank.forEach(i -> {
            RankInfoVo rankInfoVo = new RankInfoVo();
            rankInfoVo.setUserId(i);
            User userById = userMapper.getUserById(i);
            rankInfoVo.setCname(userById.getCname());
            rankInfoVo.setUserface(userById.getUserface());
            rankInfoVos.add(rankInfoVo);
        });
        return rankInfoVos;
    }
}
