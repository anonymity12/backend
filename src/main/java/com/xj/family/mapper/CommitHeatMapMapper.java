package com.xj.family.mapper;

import com.xj.family.bean.CommitDBView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// basic of mapper
@Mapper
public interface CommitHeatMapMapper {
    public List<CommitDBView> calcCommitForOnePerson(Integer userId);
}