
package com.xj.family.bean.vo;

import java.util.Date;

public class SixLogVo2 {

    private int id;
    private String logContent;
    private String logCover;
    private String logTags;
    private Date logDate;
    private int ownerId;
    private String ownerName;
    private String ownerFaceUrl;
    private long likeCounts;

    public SixLogVo2() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogContent() {
        return this.logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getLogCover() {
        return this.logCover;
    }

    public void setLogCover(String logCover) {
        this.logCover = logCover;
    }

    public String getLogTags() {
        return this.logTags;
    }

    public void setLogTags(String logTags) {
        this.logTags = logTags;
    }

    public Date getLogDate() {
        return this.logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerFaceUrl() {
        return this.ownerFaceUrl;
    }

    public void setOwnerFaceUrl(String ownerFaceUrl) {
        this.ownerFaceUrl = ownerFaceUrl;
    }

    public long getLikeCounts() {
        return this.likeCounts;
    }

    public void setLikeCounts(long likeCounts) {
        this.likeCounts = likeCounts;
    }
    @Override
    public String toString() {
        return "{" +
            " logContent='" + getLogContent() + "'" +
            ", logCover='" + getLogCover() + "'" +
            ", logTags='" + getLogTags() + "'" +
            ", logDate='" + getLogDate() + "'" +
            ", ownerName='" + getOwnerName() + "'" +
            ", ownerFaceUrl='" + getOwnerFaceUrl() + "'" +
            ", likeCounts='" + getLikeCounts() + "'" +
            "}";
    }


}