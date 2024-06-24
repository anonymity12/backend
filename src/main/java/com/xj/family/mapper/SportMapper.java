package com.xj.family.mapper;

import com.xj.family.bean.vo.SportInfoVo;
import com.xj.family.bean.vo.UserAndHisSportScoreInfoVo;



import java.util.List;

public interface SportMapper {
    List<SportInfoVo> listSportInfo(int owner);
    List<SportInfoVo> listSportRecordsOfAllUsersRecently();
    int saveSportRecord(SportInfoVo vo);
    List<UserAndHisSportScoreInfoVo> getAllUserForSportList();
}