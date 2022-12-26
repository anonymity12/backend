package com.xj.family.mapper;

import org.apache.ibatis.annotations.Param;
import com.xj.family.bean.SixLog;
import java.util.List;

public interface SixLogMapper {
    List<SixLog> getLogByPage(int offset, int size);
    SixLog getLogById(Long id);
}