/*
 * Copyright (c) 2023-01-21 23:02:53 除夕夜  <br> author tt <br>
 2024 06 27 22:22
 */

package com.xj.family.controller;

import com.xj.family.bean.dto.RegisterDTO;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.User;
import com.xj.family.service.RegisterService;
import com.xj.family.service.GoldService;
import com.xj.family.service.UserService;
import com.xj.family.config.Constants;
import com.xj.family.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

import static com.xj.family.config.Constants.INIT_ALLOC_GOLD_AMOUNT;
/**
 * 2023-01-21 23:05:20
 * tdo 2024 0627 邀请码验证机制；我在代码里写死，loginDTO必须传来：202406;20240707v1ok
 **/
@CrossOrigin
@RestController()
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @Autowired
    UserService userService;
    @Autowired
    GoldService goldService;

    @PostMapping(value = "/api/register")
    public RespBean register(@RequestBody RegisterDTO registerDTO) {
        User user = new User();
        user.setCname(registerDTO.getName());
        String cosmosIdOrEnglishName = StringUtils.convertToPinyin(registerDTO.getName());
        user.setName(cosmosIdOrEnglishName);
        user.setBirthday(registerDTO.getBirthday());
        user.setPassword(registerDTO.getPassword());
        String inviteCode = registerDTO.getInviteCode();
        System.out.println("tt>>0707: inviteCode" + inviteCode);
        boolean validInviteCode = false;
        if (inviteCode.equals("4321")) {
            System.out.println("invite code is ok");
            validInviteCode = true;
        } else {
            System.out.println("invite code is invalid");
            validInviteCode = false;
        }
        System.out.println("user before register: " + user);
        int registerReturnCode = registerService.register(user);

        // special deal for invite code, ugly inserted codes begin here;
        if (validInviteCode == false) {
            registerReturnCode = RegisterService.ERR_INVALID_INVITE_CODE;
        }
        // ugly inserted codes end here; 0707
        
        System.out.println("registerReturnCode:" + registerReturnCode);
        if (registerReturnCode < 0) {
            String errMsg = null;
            switch (registerReturnCode) {
                case RegisterService.ERR_NAME_EMPTY:
                    errMsg = "请不要空名字";
                    break;
                case RegisterService.ERR_PASSWORD_EMPTY:
                    errMsg = "请不要空群组口令";
                    break;
                case RegisterService.ERR_NAME_REPEAT:
                    errMsg = "名字重复了，请加个数字在你名后面";
                    break;
                case RegisterService.ERR_NAME_TOO_SHORT:
                    errMsg = "名字太短了";
                    break;
                case RegisterService.ERR_INVALID_INVITE_CODE:
                    errMsg = "无效邀请码，请联系天天";
                    break;
                case RegisterService.ERR_BIRTHDAY_INVALID:
                    errMsg = "出生日期 格式不对";
                    break;
                default:
                    errMsg = "其他未知错误";
                    break;
            }
        
            return RespBean.error("注册失败,原因: " + errMsg);
        }
        int userId = registerReturnCode; // if goes here, then no error happen, then registerReturnCode is just the userId we added! congrats!
        userService.setDefaultLifeStartAndEnd(userId, registerDTO.getBirthday());
        goldService.allocateNewGoldForUser(userId, INIT_ALLOC_GOLD_AMOUNT);
        return RespBean.ok("注册成功");
    }


}
