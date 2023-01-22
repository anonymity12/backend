/*
 * Copyright (c) 2023-01-21 23:02:53 除夕夜  <br> author tt <br>
 */

package com.xj.family.controller;

import com.xj.family.bean.dto.RegisterDTO;
import com.xj.family.result.Result;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.User;
import com.xj.family.service.RegisterService;
import com.xj.family.config.Constants;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
/**
 * 2023-01-21 23:05:20
 **/
@CrossOrigin
@RestController()
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/api/register")
    public RespBean register(@RequestBody RegisterDTO registerDTO) {
        User user = new User();
        /*
        user may has two inputs: 1) chinese name, 2) english name
        when 1) chinese name(moreFriendly), 
          we need change to eng for name(cosmosId)
        */
        user.setCname(registerDTO.getName());
        String cosmosIdOrEnglishName = convertToPinyin(registerDTO.getName());
        user.setName(cosmosIdOrEnglishName);
        user.setBirthday(registerDTO.getBirthday());
        user.setPassword(registerDTO.getPassword());
        System.out.println("user before register: " + user);
        RespBean ret = registerService.register(user);
        return ret;
    }

    private String convertToPinyin(String original) {
        char[] chars = original.toCharArray();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String[] converted;
        String ret = null;
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <chars.length; i++) {
                if (String.valueOf(chars[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    converted = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                    if (converted != null) {
                        sb.append(converted[0]);
                        continue;
                    }
                } else {
                    sb.append(chars[i]);
                }
            }
            ret = sb.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return ret;
    }
}
