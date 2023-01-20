package com.xj.family.controller;

import com.xj.family.service.SixLogService;
import com.xj.family.bean.SixLog;
import com.xj.family.bean.RespBean;
import com.xj.family.config.Constants;
import com.xj.family.utils.StringUtils;
import com.xj.family.interceptor.LoginInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/api/sixlog")
public class SixLogController {
    @Autowired
    SixLogService sixLogService ;

    /* should get by user, if frontend has specified for one user,
     * otherwise, get all user
     */
    @GetMapping("/{size}/{page}")
    public List<SixLog> getLogByPage(@PathVariable("size")
                                    int size,
                                    @PathVariable("page")
                                    int page) {
        return sixLogService.getLogByPage(size, page);
    }
    @GetMapping("/{id}")
    public SixLog getLogById(@PathVariable("id") Long id) {
        return sixLogService.getLogById(id);
    }
    @GetMapping("/getMine/{size}/{page}")
    public List<SixLog> getLogOfMine(@PathVariable("size")
                                    int size,
                                    @PathVariable("page")
                                    int page) {
        String username = LoginInterceptor.threadLocalUsername.get();
        return sixLogService.getLogOfMineWithPageAndSize(size, page, username); // todo 2023-01-19 23:03:35 impl it
    }

/*
 * add sixlog for one user
 */
    @PostMapping("/add")
    public RespBean addNewSixLog(@RequestBody SixLog log) {
	/*
 *	currentUser = threadLocalUser.get();
 *	log.setOwner(currentUser);
 */
        int ret = sixLogService.addNewSixLog(log);
        if (ret == 1)
            return RespBean.ok("add new six log success!");
        else 
            return RespBean.error("add sixlog failed");
    }
    @GetMapping("/getTotalAmount")
    public RespBean getTotalAmount() {
        int ret = sixLogService.getTotalAmount();
        if (ret != -1) 
            return RespBean.ok("this is the totalAmount in obj", Integer.valueOf(ret));
        else 
            return RespBean.error("failed to get sixlog total amount");
    }
    
    @CrossOrigin(origins = Constants.FRONT_URL_DEV, methods = {RequestMethod.DELETE,
                    RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS}
                , allowedHeaders = "*", allowCredentials="true")
    @PostMapping("/covers")
    public String coversUpload(MultipartFile file) {
        String folder = "/home/tt/code/CodeForFamily/backend/img_upload/";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
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
}
