package com.xj.family.controller;

import com.xj.family.mapper.FlyItemMapper;
import com.xj.family.bean.FlyItem;
import com.xj.family.bean.RespBean;
import com.xj.family.service.FlyService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/flies")
public class FlyController {
    @Autowired
    FlyService flyService;

    @GetMapping("/getAll")
    public List<FlyItem> getFlies() {
        return flyService.getAllItems();
    }

    @PostMapping("/newItem")
    public RespBean addItem(@RequestBody FlyItem item) {
        if (flyService.addItem(item) == 1) {
            return RespBean.ok("得到新蝴蝶啦！！");
        } else {
            return RespBean.error("得不到新蝴蝶:(");
        }
    }

}
