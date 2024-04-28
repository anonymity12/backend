package com.xj.family.bean.vo;

import java.util.Date;

public class StarInfoVo {
    int id;
    int owner;
    Date starDateTime;
    String starDescription;


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

    public String getStarDescription() {
        return this.starDescription;
    }

    public void setStarDescription(String starDescription) {
        this.starDescription = starDescription;
    }

    public Date getStarDateTime() {
        return this.starDateTime;
    }

    public void setStarDateTime(Date starDateTime) {
        this.starDateTime = starDateTime;
    }

    @Override
    public String toString() {
        return "StarInfoVo{" +
            " id='" + getId() + "'" +
            ", owner='" + getOwner() + "'" +
            ", starDateTime='" + getStarDateTime() + "'" +
            ", starDescription='" + getStarDescription() + "'" +
            "}";
    }

}