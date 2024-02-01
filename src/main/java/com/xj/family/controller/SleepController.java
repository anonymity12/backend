package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.SleepInfoVo;
import com.xj.family.service.SleepService;
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
TrainController at 2024/1/16 15:07
 */
@CrossOrigin
@RestController
@RequestMapping("/api/sleep")
public class SleepController {
    @Autowired
    SleepService sleepService;
    @GetMapping("/getAllMySleepRecords")
    public RespBean getAllMySleepRecords() {
        int owner = LoginInterceptor.threadLocalUserId.get();
        List<SleepInfoVo> infoVos = sleepService.getAllMySleepRecords(owner);
        System.out.println("get all sleep records for user: " + owner);
        for (SleepInfoVo vo : infoVos) {
            System.out.println(vo);
        }
        return RespBean.ok("OK", infoVos);
    }
    @GetMapping("/getSleepRecordsOfAllUsersRecently")
    public RespBean getSleepRecordsOfAllUsersRecently() {
        List<SleepInfoVo> infoVos = sleepService.getSleepRecordsOfAllUsersRecently();
        return RespBean.ok("OK", infoVos);
    }
    @PostMapping("/recordOnce")
    public RespBean recordOnce(@RequestBody Map<String, String> body) {
        int owner = LoginInterceptor.threadLocalUserId.get();
        String dateTimeString = body.get("dateTime"); //         output: 1/20/2024, 1:03:36 PM  1/23/2024, 11:03:23 PM  sleep:  2/1/2024, 9:41:08 PM

        System.out.println("jsDateTime: " + dateTimeString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy, h:mm:ss a"); // not such format: yyyy/M/d hh:mm:ss
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        Date javaDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("sleepInfoVo: " + javaDate);
        SleepInfoVo vo = new SleepInfoVo();
        vo.setOwner(owner);
        vo.setSleepDateTime(javaDate);
        System.out.println("you have sleepInfoVo: " + vo);
        sleepService.recordOnce(owner);
        return RespBean.ok("OK");
    }
}