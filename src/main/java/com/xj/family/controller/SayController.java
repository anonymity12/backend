package com.xj.family.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.Say;
import com.xj.family.service.SayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SayController {
    @Autowired
    SayService sayService;

    @GetMapping("/list")
    public Map<String, Object> getAllSays() {
        System.out.println("tt>>>> someone is trying get all says");
        List<Say> says = sayService.getAllSays();
        Map<String, Object> map = new HashMap<>();
        map.put("says", says);
        return map;
    }
    @PostMapping("/add")
    public RespBean addNewSay(Say say){
        System.out.println("tt>>>> the front end pass say param:" + say);
        int result = sayService.addNewSay(say);
        if (result == 1) {
            return new RespBean("success", say.getId() + "");
        } else {
            return new RespBean("error", "shit");
        }

    }
}
