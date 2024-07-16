package com.xj.family.controller;

import com.xj.family.bean.User;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.dto.ProfileDto;
import com.xj.family.bean.vo.LifeIndicatorVo;
import com.xj.family.bean.FamilyTreeEntity;
import com.xj.family.bean.dto.ValidParentDto;
import com.xj.family.bean.vo.RankInfoVo;
import com.xj.family.bean.vo.UserAndHisSportScoreInfoVo;
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
        int userId = LoginInterceptor.threadLocalUserId.get();
        LifeIndicatorVo vo = userService.getUserLifeIndicatorVo(userId);
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
    @GetMapping("/api/user/profile")
    public RespBean getProfile() {
        int userId = LoginInterceptor.threadLocalUserId.get();
        ProfileDto userProfile = userService.getUserProfile(userId);
        if (userProfile != null) {
            return RespBean.ok("获取信息成功", userProfile);
        } else {
            return RespBean.error("获取profile失败");
        }
    }
    @PostMapping("/api/user/profile")
    public RespBean updateProfile(@RequestBody ProfileDto profileDto) {
        System.out.println(">>>>> before update profile, we got new profile: \n\t" + profileDto);
        User u = userService.updateUserProfile(profileDto);
        if (u == null) return RespBean.error("update profile failed");
        else return RespBean.ok("update profile ok", u);
    }
    @PostMapping("/upload/userface")
    public String headerPictureUpload(MultipartFile file) {
        return userService.headerPictureUpload(file);
    }

    @GetMapping("/api/user/getMyCntOverview")
    public RespBean getMyCntOverview() {
        RankInfoVo myCntOverview = userService.getUser3KindFliesCnt();
        if (myCntOverview != null) {
            return RespBean.ok("获取我的数据统计OK", myCntOverview);
        } else {
            return RespBean.error("获取我的数据统计Failed");
        }
    }
    // for sport page, one user get other users' info, like userface
    // /api/user/getOtherUserInfo/16
    // todo 0628
    @GetMapping("/api/user/getOtherUserInfo/{userId}")
    public RespBean getOtherUserInfo(@PathVariable("userId") Integer userId) {
        UserAndHisSportScoreInfoVo vo = userService.getOtherUserInfo(userId);
        return RespBean.ok("获取运动对手的信息", vo);
    }
}
