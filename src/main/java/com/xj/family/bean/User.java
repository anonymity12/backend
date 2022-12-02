package com.xj.family.bean;

import java.util.Date;

public class User {
    private Long id;
    private Date birthday;
    private String name; // english name , used in url
    private String intro;
    private String userface;
    private String cname; // chinese name, used for front-end show 


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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
 

}