package com.xj.family.bean;

import java.util.Date;

public class CommitDBView {
    Date commitDate;
    Integer commitCount;

    public Date getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Date commitDate) {
        this.commitDate = commitDate;
    }

    public Integer getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(Integer commitCount) {
        this.commitCount = commitCount;
    }

    @Override
    public String toString() {
        return "CommitDBView{" +
                "date=" + commitDate +
                ", count=" + commitCount +
                '}';
    }
}
