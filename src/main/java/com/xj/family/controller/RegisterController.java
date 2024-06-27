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
 * todo 2024 0627 邀请码验证机制；我在代码里写死，loginDTO必须传来：202406
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
        /*
        user may has two inputs: 1) chinese name, 2) english name
        when 1) chinese name(moreFriendly), 
          we need change to eng for name(cosmosId)
        */
        user.setCname(registerDTO.getName());
        String cosmosIdOrEnglishName = StringUtils.convertToPinyin(registerDTO.getName());
        user.setName(cosmosIdOrEnglishName);
        user.setBirthday(registerDTO.getBirthday());
        user.setPassword(registerDTO.getPassword());
        System.out.println("user before register: " + user);
        int registerReturnCode = registerService.register(user);
        System.out.println("registerReturnCode:" + registerReturnCode);
        if (registerReturnCode < 0) {
            String errMsg = null;
            switch (registerReturnCode) {
                case RegisterService.ERR_NAME_EMPTY:
                    errMsg = "请不要空名字";
                    break;
                case RegisterService.ERR_PASSWORD_EMPTY:
                    errMsg = "请不要空密码";
                    break;
                case RegisterService.ERR_NAME_REPEAT:
                    errMsg = "名字重复了，请加个数字在你名后面";
                    break;
                case RegisterService.ERR_NAME_TOO_SHORT:
                    errMsg = "名字太短了";
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
