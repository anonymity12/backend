package com.xj.family.service;

import com.xj.family.bean.vo.StarInfoVo;
import com.xj.family.bean.vo.UserAndTheirStarCount;
import com.xj.family.mapper.StarMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarService {
    @Autowired
    StarMapper starMapper;
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
        log.info("SERVICE:star:record star info:" + vo);
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
}
