package com.xj.family.mapper;

import org.apache.ibatis.annotations.Param;
import com.xj.family.bean.SixLog;
import com.xj.family.bean.vo.SixLogVo;
import java.util.List;

public interface SixLogMapper {
    List<SixLogVo> getLogByPage(int offset, int size);
    SixLog getLogById(Long id);
    int addNewSixLog(SixLog sixLog);
    int getTotalAmount();
}