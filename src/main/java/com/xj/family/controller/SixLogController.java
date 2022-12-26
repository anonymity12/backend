package com.xj.family.controller;

import com.xj.family.service.SixLogService;
import com.xj.family.bean.SixLog;
import com.xj.family.bean.RespBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/api/sixlog")
public class SixLogController {
    @Autowired
    SixLogService sixLogService ;

    @GetMapping("/{size}/{page}")
    public List<SixLog> getLogByPage(@PathVariable("size")
                                    int size,
                                    @PathVariable("page")
                                    int page) {
        return sixLogService.getLogByPage(size, page);
    }
    @GetMapping("{id}")
    public SixLog getLogById(@PathVariable("id") Long id) {
        return sixLogService.getLogById(id);
    }

    @PostMapping("/add")
    public RespBean addNewSixLog(@RequestBody SixLog log) {
        int ret = sixLogService.addNewSixLog(log);
        if (ret == 1)
            return RespBean.ok("add new six log success!");
        else 
            return RespBean.error("add sixlog failed");
    }
}