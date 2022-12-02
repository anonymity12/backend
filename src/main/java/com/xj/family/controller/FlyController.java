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

    @GetMapping("/{username}/getAll")
    public List<FlyItem> getFlies(@PathVariable("username") String name) {
        return flyService.getAllItemsForUser(name);
    }

    @PostMapping("/{username}/newItem")
    public RespBean addItem(@RequestBody FlyItem item, @PathVariable("username") String name) {
        if (flyService.addItemForUser(item, name) == 1) { // todo
            return RespBean.ok("得到新蝴蝶啦！！");
        } else {
            return RespBean.error("得不到新蝴蝶:(");
        }
    }

}
