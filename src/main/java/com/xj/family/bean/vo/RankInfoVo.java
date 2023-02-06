package com.xj.family.bean.vo;

import java.io.Serializable;

public class RankInfoVo implements Serializable {
    int userId;
    String userface;
    String cname;

    int growFlyCnt;
    int diedFlyCnt;
    int babyFlyCnt;


    @Override
    public String toString() {
        return "RankInfoVo{" +
                "userId=" + userId +
                ", userface='" + userface + '\'' +
                ", cname='" + cname + '\'' +
                ", growFlyCnt=" + growFlyCnt +
                ", diedFlyCnt=" + diedFlyCnt +
                ", babyFlyCnt=" + babyFlyCnt +
                '}';
    }

    public RankInfoVo() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getGrowFlyCnt() {
        return growFlyCnt;
    }

    public void setGrowFlyCnt(int growFlyCnt) {
        this.growFlyCnt = growFlyCnt;
    }

    public int getDiedFlyCnt() {
        return diedFlyCnt;
    }

    public void setDiedFlyCnt(int diedFlyCnt) {
        this.diedFlyCnt = diedFlyCnt;
    }

    public int getBabyFlyCnt() {
        return babyFlyCnt;
    }

    public void setBabyFlyCnt(int babyFlyCnt) {
        this.babyFlyCnt = babyFlyCnt;
    }

}
