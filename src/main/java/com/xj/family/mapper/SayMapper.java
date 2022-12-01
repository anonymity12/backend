package com.xj.family.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import com.xj.family.bean.Say;

public interface SayMapper {
    int addNewSay(Say say);
    List<Say> getAllSays();
}
