package com.xj.family.mapper;

import com.xj.family.bean.vo.SleepInfoVo;


import java.util.List;

public interface SleepMapper {
    List<SleepInfoVo> listSleepInfo(int owner);
    List<SleepInfoVo> listSleepRecordsOfAllUsersRecently();
    int saveSleepRecord(int owner);
}