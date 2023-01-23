package com.xj.family.bean.dto;

import java.sql.Date;

public class RegisterDTO {
    private String name;
    private String password;
    private Date birthday;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", password='" + getPassword() + "'" +
            ", birthday='" + getBirthday() + "'" +
            "}";
    }


}