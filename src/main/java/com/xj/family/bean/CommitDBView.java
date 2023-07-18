package com.xj.family.bean;

import java.util.Date;

public class CommitDBView {
    Date date;
    Integer count;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CommitDBView{" +
                "date=" + date +
                ", count=" + count +
                '}';
    }
}
