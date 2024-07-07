/*
 * Copyright (c) 2022  12 25  <br> author tt <br>
 */

package com.xj.family.bean.dto;
public class LoginDTO {
    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
            " loginName='" + getLoginName() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}
