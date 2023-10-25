package com.xj.family.bean;

public class CardInstance {
    int id;
    int templateId;
    int hardWorkRate;
    int owner;
    Boolean status;

    public CardInstance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CardInstance{" +
                "id=" + id +
                ", templateId=" + templateId +
                ", hardWorkRate=" + hardWorkRate +
                ", owner=" + owner +
                ", status=" + status +
                '}';
    }
}
