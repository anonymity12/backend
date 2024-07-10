package com.xj.family.bean.vo;

import java.util.List;

public class StarRoadVo {
    int userId;
    String userface;
    String username;
    List<StarInfoVo> stars;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<StarInfoVo> getStars() {
        return this.stars;
    }

    public void setStars(List<StarInfoVo> stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "StarRoadVo{" +
            " userId='" + getUserId() + "'" +
            ", userface='" + getUserface() + "'" +
            ", stars='" + getStars() + "'" +
            "}";
    }
}