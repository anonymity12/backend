package com.xj.family.bean.dto;

import java.sql.Date;

public class ProfileDto {
    int id;
    String name; // chinese name
    String cosmosId; // eng name
    String userface;
    String password;
    String intro;
    Date birthday;

    @Override
    public String toString() {
        return "ProfileDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cosmosId='" + cosmosId + '\'' +
                ", userface='" + userface + '\'' +
                ", password='" + password + '\'' +
                ", intro='" + intro + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public ProfileDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCosmosId() {
        return cosmosId;
    }

    public void setCosmosId(String cosmosId) {
        this.cosmosId = cosmosId;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
