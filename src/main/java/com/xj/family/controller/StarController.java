package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.StarInfoVo;
import com.xj.family.service.StarService;
import com.xj.family.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/*
StarController at 2024/4/23 17:07
 */
@CrossOrigin
@RestController
@RequestMapping("/api/star")
public class StarController {
    @Autowired
    StarService starService;
    @GetMapping("/getAllMyStarRecords")
    public RespBean getAllMyStarRecords() {
        int owner = LoginInterceptor.threadLocalUserId.get();
        List<StarInfoVo> infoVos = starService.getAllMyStarRecords(owner);
        return RespBean.ok("OK", infoVos);
    }
    @GetMapping("/getStarRecordsOfAllUsersRecently")
    public RespBean getStarRecordsOfAllUsersRecently() {
        List<StarInfoVo> infoVos = starService.getStarRecordsOfAllUsersRecently();
        return RespBean.ok("OK", infoVos);
    }
    @PostMapping("/recordOnce")
    public RespBean recordOnce(@RequestBody Map<String, String> body) {
        int owner = LoginInterceptor.threadLocalUserId.get();
        String dateTimeString = body.get("starDateTimeString"); //         output: 1/20/2024, 1:03:36 PM  1/23/2024, 11:03:23 PM  star:  2/1/2024, 9:41:08 PM
        String starDescriptionString = body.get("starDescriptionString");

        System.out.println("tt>>> jsDateTime: " + dateTimeString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy, hh:mm:ss a"); // not such format: yyyy/M/d hh:mm:ss
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        Date javaDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        StarInfoVo vo = new StarInfoVo();
        vo.setOwner(owner);
        vo.setStarDateTime(javaDate);
        vo.setStarDescription(starDescriptionString);
        System.out.println("tt>>> user submit starInfoVo: " + vo);
        starService.recordOnce(vo);
        return RespBean.ok("OK");
    }
}