package com.xj.family.service;

import com.xj.family.bean.vo.SleepInfoVo;
import com.xj.family.mapper.SleepMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SleepService {
    @Autowired
    SleepMapper sleepMapper;

    public List<SleepInfoVo> getAllMySleepRecords(int owner) {
        List<SleepInfoVo> vos = sleepMapper.listSleepInfo(owner);
        return vos;
    }
    public List<SleepInfoVo> getSleepRecordsOfAllUsersRecently() {
        List<SleepInfoVo> vos = sleepMapper.listSleepRecordsOfAllUsersRecently();
        return vos;
    }

    public int recordOnce(int owner) {
        sleepMapper.saveSleepRecord(owner);
        return 1;
    }
}
