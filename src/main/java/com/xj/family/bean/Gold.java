package com.xj.family.bean;

public class Gold {
    private int ownerId;
    private int amount;

    public Gold() {
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Gold{" +
                "ownerId=" + ownerId +
                ", amount=" + amount +
                '}';
    }
}
