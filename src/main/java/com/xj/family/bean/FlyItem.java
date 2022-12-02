package com.xj.family.bean;

import java.util.Date;

public class FlyItem {


    private Long id;
    private Date date;
    private String name;
    private String evaluate;
    private String image;
    private Long owner;

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", date='" + getDate() + "'" +
            ", name='" + getName() + "'" +
            ", evaluate='" + getEvaluate() + "'" +
            ", image='" + getImage() + "'" +
            ", owner='" + getOwner() + "'" +
            "}";
    }


    public Long getOwner() {
        return this.owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}