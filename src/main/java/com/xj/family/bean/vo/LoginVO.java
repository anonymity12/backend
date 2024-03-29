/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.bean.vo;


import com.xj.family.bean.User;

import java.io.Serializable;

/**
  todo 2023-01-19 20:32:54 try not use User inside as a member; may has serialization error, but test will tell us
  todo 2023-01-24 23:09:51 maybe loginVo should contain profileDto, instead a user
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