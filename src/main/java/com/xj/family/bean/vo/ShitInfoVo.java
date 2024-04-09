package com.xj.family.bean.vo;

import java.util.Date;

public class ShitInfoVo {
    int id;
    int owner;
    Date shitDateTime;


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

    public Date getShitDateTime() {
        return this.shitDateTime;
    }

    public void setShitDateTime(Date shitDateTime) {
        this.shitDateTime = shitDateTime;
    }

    @Override
    public String toString() {
        return "ShitInfoVo{" +
            " id='" + getId() + "'" +
            ", owner='" + getOwner() + "'" +
            ", shitDateTime='" + getShitDateTime() + "'" +
            "}";
    }

}