package com.xj.family.bean.vo;

import java.sql.Date;

public class LifeIndicatorVo {
    Long userId; 
    int dayPassed;
    int dayAll;

    public LifeIndicatorVo() {}


    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", dayPassed='" + getDayPassed() + "'" +
            ", dayAll='" + getDayAll() + "'" +
            "}";
    }
 

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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