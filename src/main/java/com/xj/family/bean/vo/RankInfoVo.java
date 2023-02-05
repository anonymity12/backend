package com.xj.family.bean.vo;

import java.io.Serializable;

public class RankInfoVo implements Serializable {
    int userId;
    String userface;
    String cname;

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
}
