package com.xj.family.bean.vo;

import java.util.Date;
import java.util.Objects;

public class UserAndTheirStarCount {
    int userId;
    int cnt;
    String username;
    String userface;


    public UserAndTheirStarCount() {
    }

    public UserAndTheirStarCount(int userId, int cnt, String username, String userface) {
        this.userId = userId;
        this.cnt = cnt;
        this.username = username;
        this.userface = userface;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCnt() {
        return this.cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserface() {
        return this.userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public UserAndTheirStarCount userId(int userId) {
        setUserId(userId);
        return this;
    }

    public UserAndTheirStarCount cnt(int cnt) {
        setCnt(cnt);
        return this;
    }

    public UserAndTheirStarCount username(String username) {
        setUsername(username);
        return this;
    }

    public UserAndTheirStarCount userface(String userface) {
        setUserface(userface);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserAndTheirStarCount)) {
            return false;
        }
        UserAndTheirStarCount userAndTheirStarCount = (UserAndTheirStarCount) o;
        return userId == userAndTheirStarCount.userId && cnt == userAndTheirStarCount.cnt && Objects.equals(username, userAndTheirStarCount.username) && Objects.equals(userface, userAndTheirStarCount.userface);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, cnt, username, userface);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", cnt='" + getCnt() + "'" +
            ", username='" + getUsername() + "'" +
            ", userface='" + getUserface() + "'" +
            "}";
    }

}