package com.xj.family.service;

import com.xj.family.bean.vo.SportInfoVo;
import com.xj.family.bean.vo.UserAndHisSportScoreInfoVo;
import com.xj.family.mapper.SportMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportService {
    @Autowired
    SportMapper sportMapper;

    public List<SportInfoVo> getAllMySportRecords(int owner) {
        List<SportInfoVo> vos = sportMapper.listSportInfo(owner);
        return vos;
    }
    public List<SportInfoVo> getCompetitorRecords(int competitorId) {
        List<SportInfoVo> vos = sportMapper.listSportInfo(competitorId);
        return vos;
    }

    public List<UserAndHisSportScoreInfoVo> getAllUserForSportList() {
        List<UserAndHisSportScoreInfoVo> infoVos = sportMapper.getAllUserForSportList();
        return infoVos;

    }
    public List<SportInfoVo> getSportRecordsOfAllUsersRecently() {
        List<SportInfoVo> vos = sportMapper.listSportRecordsOfAllUsersRecently();
        return vos;
    }

    public int recordOnce(SportInfoVo vo) {
        System.out.println("SERVICE:sport:record sport info:" + vo);
        sportMapper.saveSportRecord(vo);
        return 1;
    }
}