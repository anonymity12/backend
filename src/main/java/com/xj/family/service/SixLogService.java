package com.xj.family.service; 

import com.xj.family.mapper.SixLogMapper;
import com.xj.family.bean.SixLog; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service 
public class SixLogService {
    @Autowired
    SixLogMapper sixLogMapper;
    
    public List<SixLog> getLogByPage(int size, int page) {
        int offset = size * (page - 1);
        return sixLogMapper.getLogByPage(offset, size);
    }
    public SixLog getLogById(Long id) {
        return sixLogMapper.getLogById(id);
    }
}