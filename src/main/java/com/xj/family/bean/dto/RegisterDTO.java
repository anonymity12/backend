package com.xj.family.bean.dto;

import java.sql.Date;

public class RegisterDTO {
    private String name;
    private String password;
    private Date birthday;
    private String inviteCode;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", password='" + getPassword() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", inviteCode='" + getInviteCode() + "'" +
            "}";
    }

}