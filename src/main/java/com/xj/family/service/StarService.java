package com.xj.family.service;

import com.xj.family.bean.User;
import com.xj.family.bean.vo.StarInfoVo;
import com.xj.family.bean.vo.StarRoadVo;
import com.xj.family.bean.vo.UserAndTheirStarCount;
import com.xj.family.mapper.StarMapper;
import com.xj.family.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.xj.family.util.BusinessConstants.STAR_RECENT_CNT_DEF;

@Service
public class StarService {
    @Autowired
    StarMapper starMapper;
    @Autowired
    UserMapper userMapper;
    private static final Logger log = LoggerFactory.getLogger(StarService.class);


    public List<StarInfoVo> getAllMyStarRecords(int owner) {
        List<StarInfoVo> vos = starMapper.listStarInfo(owner);
        return vos;
    }
    public List<StarInfoVo> getStarRecordsOfAllUsersRecently() {
        List<StarInfoVo> vos = starMapper.listStarRecordsOfAllUsersRecently();
        return vos;
    }

    public int recordOnce(StarInfoVo vo) {
        starMapper.saveStarRecord(vo);
        return 1;
    }

    public List<UserAndTheirStarCount> getStarRaceBayData() {
        List<UserAndTheirStarCount> vos = starMapper.getStarRaceBayData();
        return vos;
    }
    public List<UserAndTheirStarCount> getStarWeeklyData() {
        List<UserAndTheirStarCount> vos = starMapper.getStarWeeklyData();
        return vos;
    }
    public List<StarRoadVo> getStarRoad() {
        List<Integer> userIds = userMapper.getRecentlyActiveTenUsersIds();
        List<StarRoadVo> starRoadVos = new ArrayList<>();
        for (int userId: userIds) {
            StarRoadVo starRoadVo = new StarRoadVo();
            User user = userMapper.getUserById(userId);
            List<StarInfoVo> stars = starMapper.listRecentStarsForUser(userId, STAR_RECENT_CNT_DEF);
            starRoadVo.setUsername(user.getCname());
            starRoadVo.setUserId(user.getId());
            starRoadVo.setUserface(user.getUserface());
            starRoadVo.setStars(stars);
            starRoadVos.add(starRoadVo);
        }
        return starRoadVos;
    }
}
