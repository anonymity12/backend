/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.vo;


import com.xj.family.bean.User;

import java.io.Serializable;

/**
 * @Author: 三分恶
 * @Date: 2021/1/18
 * @Description: 登录VO
  tt todo 2023-01-19 20:26:17 : we need move it to bean/vo folder
  todo 2023-01-19 20:32:54 try not use User inside as a member; may has serialization error, but test will tell us
 **/

public class LoginVO implements Serializable {
    private Integer id;
    private String token;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}