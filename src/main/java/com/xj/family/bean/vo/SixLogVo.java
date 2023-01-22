
package com.xj.family.bean.vo;

import java.util.Date;

public class SixLogVo{

    private Long id;
    private String articleTitle;
    private String articleContentHtml;
    private String articleContentMd;
    private String articleAbstract;
    private String articleCover;
    private Date articleDate;
    private String ownerName;

    SixLogVo() {

    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", articleTitle='" + getArticleTitle() + "'" +
            ", articleContentHtml='" + getArticleContentHtml() + "'" +
            ", articleContentMd='" + getArticleContentMd() + "'" +
            ", articleAbstract='" + getArticleAbstract() + "'" +
            ", articleCover='" + getArticleCover() + "'" +
            ", articleDate='" + getArticleDate() + "'" +
            ", ownerName='" + getOwnerName() + "'" +
            "}";
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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


}
