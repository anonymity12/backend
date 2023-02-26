package com.xj.family.bean;

import java.sql.Date;

public class User {
    private int id;
    private Date birthday;
    private String name; // english name , used in url. or we should change it to cosmosId, it's a better name; but now 0226, just use `name`
    private String intro;
    private String userface;
    private String cname; // chinese name, used for front-end show 
    private String password;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getUserface() {
        return this.userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }


    public String getCname() {
        return this.cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", name='" + getName() + "'" +
            ", intro='" + getIntro() + "'" +
            ", userface='" + getUserface() + "'" +
            ", cname='" + getCname() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }
}