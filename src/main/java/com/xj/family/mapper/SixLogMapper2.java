package com.xj.family.mapper;

import org.apache.ibatis.annotations.Param;
import com.xj.family.bean.vo.SixLogVo2;
import java.util.List;

public interface SixLogMapper2 {
    List<SixLogVo2> getLogByPage(int offset, int size);
    List<SixLogVo2> getLogByTagByPage(String tag, int offset, int size);
    // SixLog getLogById(Long id);
    int addNewSixLog(SixLogVo2 log2);
    // int getTotalAmount();
}