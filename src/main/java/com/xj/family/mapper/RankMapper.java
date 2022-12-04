package com.xj.family.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.lang.Integer;

public interface RankMapper {
    List<Integer> getUserListRanked();
}
