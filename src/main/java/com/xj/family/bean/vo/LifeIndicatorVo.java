package com.xj.family.bean.vo;

import java.sql.Date;

public class LifeIndicatorVo {
    String username; 
    int dayPassed;
    int dayAll;

    public LifeIndicatorVo() {}


    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", dayPassed='" + getDayPassed() + "'" +
            ", dayAll='" + getDayAll() + "'" +
            "}";
    }
 


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDayPassed() {
        return this.dayPassed;
    }

    public void setDayPassed(int dayPassed) {
        this.dayPassed = dayPassed;
    }

    public int getDayAll() {
        return this.dayAll;
    }

    public void setDayAll(int dayAll) {
        this.dayAll = dayAll;
    }


}