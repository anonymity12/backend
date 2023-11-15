package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.service.TomatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/tomato")
public class TomatoController {
    @Autowired
    TomatoService tomatoService;
    @GetMapping("/queryTotalCounts")
    public RespBean queryTotalCounts() {
        System.out.println("C:queryTotalCounts");
        int counts = tomatoService.queryTotalCounts();
        return RespBean.ok("queryTotalCounts success", counts);
    }
    @GetMapping("/queryTodayCounts")
    public RespBean queryTodayCounts() {
        System.out.println("C: queryTodayCounts");
        int counts = tomatoService.queryTodayCounts();
        return RespBean.ok("queryTodayCounts success", counts);
    }
    @PostMapping("/finish")
    public RespBean finish() {
        System.out.println("C: finish tomato.");
        int ret = tomatoService.finishTomato();
        if (ret > 1) {
            return RespBean.ok("finish tomato success");
        } else {
            return RespBean.error("finish tomato failed");
        }
    }
}
