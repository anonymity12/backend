package com.xj.family.bean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// this file is useless most likely, cause tt want to calculated obj at SixLogController2, tt may dont need a concret class for redis representation.
@JsonIgnoreProperties(ignoreUnknown = true)
public class SixLogRedisEntry {
    private String logTime;
    private String textContent;
    private String imageUrl;
    private String author;
    private String tag;

    public SixLogRedisEntry() {
    }

    public SixLogRedisEntry(String logTime, String textContent, String imageUrl, String author, String tag) {
        this.logTime = logTime;
        this.textContent = textContent;
        this.imageUrl = imageUrl;
        this.author = author;
        this.tag = tag;
    }

    public String getLogTime() {
        return this.logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getTextContent() {
        return this.textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public SixLogRedisEntry logTime(String logTime) {
        setLogTime(logTime);
        return this;
    }

    public SixLogRedisEntry textContent(String textContent) {
        setTextContent(textContent);
        return this;
    }

    public SixLogRedisEntry imageUrl(String imageUrl) {
        setImageUrl(imageUrl);
        return this;
    }

    public SixLogRedisEntry author(String author) {
        setAuthor(author);
        return this;
    }

    public SixLogRedisEntry tag(String tag) {
        setTag(tag);
        return this;
    }
 
    @Override
    public String toString() {
        return "{" +
            " logTime='" + getLogTime() + "'" +
            ", textContent='" + getTextContent() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", author='" + getAuthor() + "'" +
            ", tag='" + getTag() + "'" +
            "}";
    }
}