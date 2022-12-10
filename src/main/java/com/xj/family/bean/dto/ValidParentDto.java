package com.xj.family.bean.dto;


public class ValidParentDto {
    String parent_passwd;
    ValidParentDto() {
        
    }

    public String getParent_passwd() {
        return this.parent_passwd;
    }

    public void setParent_passwd(String parent_passwd) {
        this.parent_passwd = parent_passwd;
    }

    @Override
    public String toString() {
        return "{" +
            " parentPasswd='" + getParent_passwd() + "'" +
            "}";
    }

}