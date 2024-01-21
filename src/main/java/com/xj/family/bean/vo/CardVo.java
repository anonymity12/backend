package com.xj.family.bean.vo;

public class CardVo {
    // ---- ⬇ contains whole field of cardInstance ️----
    int id;
    int templateId;
    int hardWorkRate;
    int owner;
    Boolean status;
    // ---- ⬆ contains whole field of cardInstance ️️----

    String ownerName; // derive from user table

    // ---- ⬇ contains whole field of cardTemplate ️----
    String name;
    int series;
    String imageUrl;
    int basePrice;
    String desc;
    // ---- ⬆ contains whole field of cardTemplate ️️----


    int finalPrice; // 卡片的实际最终价值=base_price * 1.05^{hard_work_rate}

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void calcFinalPrice() {
        // for example: 250 * (1.05^57) = 4033 ; everything is fine
        this.finalPrice = (int) (basePrice * Math.pow(1.05, this.hardWorkRate));
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public int getHardWorkRate() {
        return hardWorkRate;
    }

    public void setHardWorkRate(int hardWorkRate) {
        this.hardWorkRate = hardWorkRate;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
