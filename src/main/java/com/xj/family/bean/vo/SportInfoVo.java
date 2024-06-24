package com.xj.family.bean.vo;

import java.util.Date;

public class SportInfoVo {
    int id;
    int owner;
    Date sportDateTime;
    String sportContent;

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

    public Date getSportDateTime() {
        return this.sportDateTime;
    }

    public void setSportDateTime(Date sportDateTime) {
        this.sportDateTime = sportDateTime;
    }

    public String getSportContent() {
        return this.sportContent;
    }

    public void setSportContent(String sportContent) {
        this.sportContent = sportContent;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", owner='" + getOwner() + "'" +
            ", sportDateTime='" + getSportDateTime() + "'" +
            ", sportContent='" + getSportContent() + "'" +
            "}";
    }
}