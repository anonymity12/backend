package com.xj.family.bean.vo;

import java.util.Date;

public class UserAndHisSportScoreInfoVo {
    int userId;
    String userface;
    int score;


    public UserAndHisSportScoreInfoVo() {
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserface() {
        return this.userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", userface='" + getUserface() + "'" +
            ", score='" + getScore() + "'" +
            "}";
    }

}