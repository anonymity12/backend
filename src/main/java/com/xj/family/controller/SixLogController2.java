package com.xj.family.controller;

import com.xj.family.service.GoldService;
import com.xj.family.service.SixLogService2;
import com.xj.family.bean.vo.SixLogVo2;
import com.xj.family.bean.RespBean;
import com.xj.family.config.Constants;
import com.xj.family.utils.StringUtils;
import com.xj.family.interceptor.LoginInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Date;

import static com.xj.family.config.Constants.ADD_SIXLOG_REWARD;
// a sixlog2 controller is responsible for following things:
// 1) ^^ create new sixlog2
// 2) **read a list of sixlog2
// 3) update/delete is not support yet 1207
// 4) **read hotest sixlog2 recently(redis stuff)
// 5) **auto-gen hotest sixlog2(schedule task, redis stuff)

@CrossOrigin
@RestController
@RequestMapping("/api/sixlog2")
public class SixLogController2 {
    @Autowired
    SixLogService2 sixLogService2 ;
    @Autowired
    GoldService goldService;

    @PostMapping("/add")
    public RespBean addNewSixLog(@RequestBody SixLogVo2 log) {
        int userId = LoginInterceptor.threadLocalUserId.get();
        int ret = sixLogService2.addNewSixLog(log, userId);
        goldService.addGoldForUser(userId, ADD_SIXLOG_REWARD);
        if (ret == 1)
            return RespBean.ok("成功写入浮生六记");
        else 
            return RespBean.error("写入浮生六记失败了");
    }
    @GetMapping("/all/{size}/{page}")
    public List<SixLogVo2> getLogByPage(@PathVariable("size")int size,
                                    @PathVariable("page")int page) {
        return sixLogService2.getLogByPage(size, page);
    }
    @GetMapping("/tag/{logTag}/{size}/{page}")
    public List<SixLogVo2> getLogByTagByPage(@PathVariable("size") int size,
                                    @PathVariable("page")int page,
                                    @PathVariable("logTag")String logTag) {
        return sixLogService2.getLogByTagByPage(logTag, size, page);
    }

// ------------------- old code below -------------------
/*

    @GetMapping("/{id}")
    public SixLog getLogById(@PathVariable("id") Long id) {
        return sixLogService.getLogById(id);
    }
    @PostMapping("/likeSixLog")
    public RespBean likeSixLog(@RequestParam int sixLogId) {
        int userId = LoginInterceptor.threadLocalUserId.get();
        sixLogService.likeLogById(userId, sixLogId);
        return RespBean.ok("点赞是个好习惯！");
    }
    @GetMapping("/getMine/{size}/{page}")
    public List<SixLog> getLogOfMine(@PathVariable("size")
                                    int size,
                                    @PathVariable("page")
                                    int page) {
        int userId = LoginInterceptor.threadLocalUserId.get();
        return sixLogService.getLogOfMineWithPageAndSize(size, page, userId); // todo 2023-01-19 23:03:35 impl it
    }


    @GetMapping("/getTotalAmount")
    public RespBean getTotalAmount() {
        int ret = sixLogService.getTotalAmount();
        if (ret != -1) 
            return RespBean.ok("this is the totalAmount in obj", Integer.valueOf(ret));
        else 
            return RespBean.error("failed to get sixlog total amount");
    }

    @PostMapping("/covers")
    public String coversUpload(MultipartFile file) {
        System.out.println("img upload, file is: " + file);
        String folder = "/home/tt/code/CodeForFamily/backend/img_upload/";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 5));// -5 for .JPEG like file
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = Constants.SERVER_URL + "/api/img/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
*/
}
