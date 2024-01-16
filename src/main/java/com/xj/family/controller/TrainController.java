package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.TrainInfoVo;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
TrainController at 2024/1/16 15:07
 */
@CrossOrigin
@RestController
@RequestMapping("/api/train")
public class TrainController {
    @Autowired
    TrainService trainService;
    @GetMapping("/getStationsInfoList")
    public RespBean getStationsInfoList() {
        List<TrainInfoVo> infoVos = trainService.getStationsInfoList();
        return RespBean.ok("OK", infoVos);
    }
}