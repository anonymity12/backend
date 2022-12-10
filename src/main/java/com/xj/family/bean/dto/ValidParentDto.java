package com.xj.family.bean.dto;


public class ValidParentDto {
    String parentPasswd;
    ValidParentDto() {
        this.parentPasswd = "2023"
    }

    public String getParentPasswd() {
        return this.parentPasswd;
    }

    public void setParentPasswd(String parentPasswd) {
        this.parentPasswd = parentPasswd;
    }

}