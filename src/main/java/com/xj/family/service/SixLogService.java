package com.xj.family.service; 

import com.xj.family.mapper.SixLogMapper;
import com.xj.family.mapper.UserMapper;
import com.xj.family.bean.SixLog; 
import com.xj.family.bean.vo.SixLogVo; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service 
public class SixLogService {
    @Autowired
    SixLogMapper sixLogMapper;
    @Autowired 
    UserMapper userMapper;
    
    public List<SixLogVo> getLogByPage(int size, int page) {
        int offset = size * (page - 1);
        return sixLogMapper.getLogByPage(offset, size);
    }
    public SixLog getLogById(Long id) {
        return sixLogMapper.getLogById(id);
    }
    public int addNewSixLog(SixLog log, String username) {
        Long userId = userMapper.getUserIdByName(username);
        System.out.println("username: id ->" + username + ": " + userId);
        log.setOwnerId(userId);
        return sixLogMapper.addNewSixLog(log);
    }
    public int getTotalAmount() {
        return sixLogMapper.getTotalAmount();
    }
    public List<SixLog> getLogOfMineWithPageAndSize(int size, int page, String username) {
        // System.out.println("SixLogService: getLogOfMineWithPageAndSize: for user: " + username);
        return null; // sixLogMapper impl 
    }
}