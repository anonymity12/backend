package com.xj.family.bean.vo;

import java.util.Date;

public class SleepInfoVo {
    int id;
    int owner;
    Date sleepDateTime;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner() {
        return this.owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public Date getSleepDateTime() {
        return this.sleepDateTime;
    }

    public void setSleepDateTime(Date sleepDateTime) {
        this.sleepDateTime = sleepDateTime;
    }

    @Override
    public String toString() {
        return "SleepInfoVo{" +
            " id='" + getId() + "'" +
            ", owner='" + getOwner() + "'" +
            ", sleepDateTime='" + getSleepDateTime() + "'" +
            "}";
    }

}