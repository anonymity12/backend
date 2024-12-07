package com.xj.family.mapper;

import org.apache.ibatis.annotations.Param;
import com.xj.family.bean.SixLog2;
import com.xj.family.bean.vo.SixLogVo;
import java.util.List;

public interface SixLogMapper2 {
    // List<SixLogVo> getLogByPage(int offset, int size);
    // SixLog getLogById(Long id);
    int addNewSixLog(SixLog2 log2);
    // int getTotalAmount();
}