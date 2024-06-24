package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.vo.SportInfoVo;
import com.xj.family.bean.vo.UserAndHisSportScoreInfoVo;
import com.xj.family.service.SportService;
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
SportController at 2024/5/14 08:07
 */
@CrossOrigin
@RestController
@RequestMapping("/api/sport")
public class SportController {
    @Autowired
    SportService sportService;
    @GetMapping("/getAllMySportRecords")
    public RespBean getAllMySportRecords() {
        int owner = LoginInterceptor.threadLocalUserId.get();
        List<SportInfoVo> infoVos = sportService.getAllMySportRecords(owner);
        System.out.println("get all sport records for user: " + owner);
        for (SportInfoVo vo : infoVos) {
            System.out.println(vo);
        }
        return RespBean.ok("OK", infoVos);
    }
    @GetMapping("/getCompetitorRecords/{competitorId}")
    public RespBean getCompetitorRecords(@PathVariable("competitorId") String competitorId) {
        List<SportInfoVo> infoVos = sportService.getCompetitorRecords(Integer.valueOf(competitorId));
        return RespBean.ok("OK", infoVos);
    }
    @GetMapping("/getAllUserForSportList")
    public RespBean getAllUserForSportList() {
        List<UserAndHisSportScoreInfoVo> infoVos = sportService.getAllUserForSportList();
        return RespBean.ok("所有用户的信息和他的分数列表", infoVos);
    }
    @GetMapping("/getSportRecordsOfAllUsersRecently")
    public RespBean getSportRecordsOfAllUsersRecently() {
        List<SportInfoVo> infoVos = sportService.getSportRecordsOfAllUsersRecently();
        return RespBean.ok("OK", infoVos);
    }
    @PostMapping("/recordOnce")
    public RespBean recordOnce(@RequestBody Map<String, String> body) {
        int owner = LoginInterceptor.threadLocalUserId.get();
        String dateTimeString = body.get("dateTime"); //         output: 1/20/2024, 1:03:36 PM  1/23/2024, 11:03:23 PM  sport:  2/1/2024, 9:41:08 PM

        System.out.println("jsDateTime: " + dateTimeString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy, hh:mm:ss a"); // not such format: yyyy/M/d hh:mm:ss
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        Date javaDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("sportInfoVo: " + javaDate);
        SportInfoVo vo = new SportInfoVo();
        vo.setOwner(owner);
        vo.setSportDateTime(javaDate);
        vo.setSportContent("我静态运动啦");
        System.out.println("you have sportInfoVo: " + vo);
        sportService.recordOnce(vo);
        return RespBean.ok("OK");
    }
}