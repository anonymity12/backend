package com.xj.family.service;

import com.xj.family.bean.vo.TrainInfoVo;
import com.xj.family.mapper.TrainMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {
    @Autowired
    TrainMapper trainMapper;

    public List<TrainInfoVo> getStationsInfoList() {
        List<TrainInfoVo> vos = trainMapper.listTrainInfo();
        return vos;
    }