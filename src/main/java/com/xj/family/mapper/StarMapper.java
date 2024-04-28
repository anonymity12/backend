package com.xj.family.mapper;

import com.xj.family.bean.vo.StarInfoVo;


import java.util.List;

public interface StarMapper {
    List<StarInfoVo> listStarInfo(int owner);
    List<StarInfoVo> listStarRecordsOfAllUsersRecently();
    int saveStarRecord(StarInfoVo vo);
}