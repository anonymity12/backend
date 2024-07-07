package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.SleepInfoVo;
import com.xj.family.service.SleepService;
import com.xj.family.interceptor.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
/*
SleepController at 2024/1/16 15:07
20240707 19:40 add logger;
    note: log level: error, warn, info; debug ,trace
 */
@CrossOrigin
@RestController
@RequestMapping("/api/sleep")
public class SleepController {
    @Autowired
    SleepService sleepService;
    private static final Logger log = LoggerFactory.getLogger(SleepController.class);

    @GetMapping("/getAllMySleepRecords")
    public RespBean getAllMySleepRecords() {
        int owner = LoginInterceptor.threadLocalUserId.get();
        List<SleepInfoVo> infoVos = sleepService.getAllMySleepRecords(owner);
        System.out.println("get all sleep records for user: " + owner);
        for (SleepInfoVo vo : infoVos) {
            log.debug(""+vo);
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

        log.debug("jsDateTime: " + dateTimeString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy, hh:mm:ss a"); // not such format: yyyy/M/d hh:mm:ss
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        Date javaDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        log.error("sleepInfoVo: " + javaDate);
        SleepInfoVo vo = new SleepInfoVo();
        vo.setOwner(owner);
        vo.setSleepDateTime(javaDate);
        log.info("you have sleepInfoVo: " + vo);
        sleepService.recordOnce(owner);
        return RespBean.ok("OK");
    }
}