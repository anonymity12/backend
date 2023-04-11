
package com.xj.family.bean.vo;

import java.util.Date;

public class SixLogVo {

    private Integer id; // 2023-04-11 22:23:09 consider change it to Integer
    private String articleTitle;
    private String articleContentHtml;
    private String articleContentMd;
    private String articleAbstract;
    private String articleCover;
    private Date articleDate;
    private String ownerName;
    // 2023-04-11 22:20:02 add for like counts
    private long likeCounts;

    SixLogVo() {

    }

    @Override
    public String toString() {
        return "SixLogVo{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContentHtml='" + articleContentHtml + '\'' +
                ", articleContentMd='" + articleContentMd + '\'' +
                ", articleAbstract='" + articleAbstract + '\'' +
                ", articleCover='" + articleCover + '\'' +
                ", articleDate=" + articleDate +
                ", ownerName='" + ownerName + '\'' +
                ", likeCounts=" + likeCounts +
                '}';
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return this.articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContentHtml() {
        return this.articleContentHtml;
    }

    public void setArticleContentHtml(String articleContentHtml) {
        this.articleContentHtml = articleContentHtml;
    }

    public String getArticleContentMd() {
        return this.articleContentMd;
    }

    public void setArticleContentMd(String articleContentMd) {
        this.articleContentMd = articleContentMd;
    }

    public String getArticleAbstract() {
        return this.articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getArticleCover() {
        return this.articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    public Date getArticleDate() {
        return this.articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(long likeCounts) {
        this.likeCounts = likeCounts;
    }

}
