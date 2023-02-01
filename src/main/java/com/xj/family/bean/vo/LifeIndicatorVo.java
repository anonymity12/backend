package com.xj.family.bean.vo;

import java.sql.Date;

public class LifeIndicatorVo {

    int dayPassed;
    int dayAll;

    public LifeIndicatorVo() {}


    @Override
    public String toString() {
        return "{" +
            ", dayPassed='" + getDayPassed() + "'" +
            ", dayAll='" + getDayAll() + "'" +
            "}";
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