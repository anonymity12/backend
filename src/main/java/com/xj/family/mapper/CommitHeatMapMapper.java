package com.xj.family.mapper;

import com.xj.family.bean.CommitDBView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// basic of mapper
@Mapper
public interface CommitHeatMapMapper {
    /*
    select DATE(edited), count(*) from task where owner=16 group by DATE(edited);
    select DATE(edited), count(*) from task where owner=16 and status=2 group by DATE(edited);
     */
    List<CommitDBView> calcCommitForOnePerson(Integer userId);
}