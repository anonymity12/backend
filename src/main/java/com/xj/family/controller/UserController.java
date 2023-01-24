package com.xj.family.controller;

import com.xj.family.bean.User;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.dto.ProfileDto;
import com.xj.family.bean.vo.LifeIndicatorVo;
import com.xj.family.bean.FamilyTreeEntity;
import com.xj.family.bean.dto.ValidParentDto;
import com.xj.family.config.Constants;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.service.UserService;
import com.xj.family.service.FamilyTreeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    FamilyTreeService familyTreeService;

    @GetMapping("/users/{username}/getInfo")
    public User getInfo(@PathVariable("username") String name) {
        return userService.getUserInfoByName(name);
    }

    @PostMapping("/users/validParent")
    public RespBean validParent(@RequestBody ValidParentDto item) {
        System.out.println("controller recieve valid parent dto: " + item);
        if (userService.validParent(item)) { 
            return RespBean.ok("验证通过");
        } else {
            return RespBean.error("验证不通过");
        }
    }

    @GetMapping("/api/lifeIndicator")
    public RespBean lifeIndicator() {
        // todo find out multi users, who make this request
        String username = LoginInterceptor.threadLocalUsername.get();
        LifeIndicatorVo vo = userService.getUserLifeIndicatorVo(username);
        if (vo != null) {
            return RespBean.ok("got user life indicator", vo);
        } else {
            return RespBean.error("faild to get user life indicator");
        }
    }
    /*
    @GetMapping("/familyTree")
    public RespBean familyTree() {
        List<FamilyTreeEntity> entities = familyTreeService.list();
        List<FamilyTreeEntity> level1Entities = entities.stream()
                                .filter((entity) -> entity.getParentId() == 0)
                                .map((node) -> {
                                    node.setChild(getChildren(node, entities));
                                    return node;
                                })
                                .collect(Collectors.toList());
        return RespBean.ok("got family tree", level1Entities);
    }
    private List<FamilyTreeEntity> getChildren(FamilyTreeEntity parent, List<FamilyTreeEntity> allMembers) {

        return null;
    }
    */
    @GetMapping("/api/user/profile/")
    public RespBean getProfile() {
        String username = LoginInterceptor.threadLocalUsername.get();
        ProfileDto userProfile = userService.getUserProfile(username);
        if (userProfile != null) {
            return RespBean.ok("获取信息成功", userProfile);
        } else {
            return RespBean.error("获取profile失败");
        }
    }
    @PostMapping("/api/user/profile/")
    public RespBean updateProfile(@RequestBody ProfileDto profileDto) {
        System.out.println(">>>>> before update profile, we got profile: \n\t" + profileDto);
        int a = userService.updateUserProfile(profileDto);
        if (a < 0) return RespBean.error("update profile failed");
        else return RespBean.ok("update profile ok");
    }
    @PostMapping("/upload/userface")
    public String headerPictureUpload(MultipartFile file) {
        String username = LoginInterceptor.threadLocalUsername.get();
        /* // we decide not to use 2023-01-02 as prefix, but username now;
        Calendar a = Calendar.getInstance();
        Date time = a.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(time);
        */
        System.out.println("header picture upload, file is: " + file);

        String folder = "/home/tt/code/CodeForFamily/backend/img_upload/";
        File imageFolder = new File(folder);
        String imgName = username + com.xj.family.utils.StringUtils.getRandomString(6)
                + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
        File f = new File(imageFolder, imgName);
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
