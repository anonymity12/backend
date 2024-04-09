package com.xj.family.service;

import com.xj.family.bean.vo.ShitInfoVo;
import com.xj.family.mapper.ShitMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShitService {
    @Autowired
    ShitMapper shitMapper;

    public List<ShitInfoVo> getAllMyShitRecords(int owner) {
        List<ShitInfoVo> vos = shitMapper.listShitInfo(owner);
        return vos;
    }
    public List<ShitInfoVo> getShitRecordsOfAllUsersRecently() {
        List<ShitInfoVo> vos = shitMapper.listShitRecordsOfAllUsersRecently();
        return vos;
    }

    public int recordOnce(int owner) {
        System.out.println("SERVICE:shit:record shit time for user" + owner);
        shitMapper.saveShitRecord(owner);
        return 1;
    }
}
