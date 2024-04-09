package com.xj.family.mapper;

import com.xj.family.bean.vo.ShitInfoVo;


import java.util.List;

public interface ShitMapper {
    List<ShitInfoVo> listShitInfo(int owner);
    List<ShitInfoVo> listShitRecordsOfAllUsersRecently();
    int saveShitRecord(int owner);
}