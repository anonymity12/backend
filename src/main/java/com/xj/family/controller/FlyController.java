package com.xj.family.controller;

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
    @PostMapping("/growStatus/{flyId}")
    public RespBean growStatus(@PathVariable("flyId") Long flyId) {
        if (flyService.growStatus(flyId) == 1) {
            return RespBean.ok("蝴蝶进化成功");
        } else {
            return RespBean.error("蝴蝶进化失败");
        }
    }
    @PostMapping("/releaseStatus/{flyId}")
    public RespBean releaseStatus(@PathVariable("flyId") Long flyId) {
        if (flyService.releaseStatus(flyId) == 1) {
            return RespBean.ok("蝴蝶放生成功");
        } else {
            return RespBean.error("蝴蝶放生失败");
        }
    }
}
