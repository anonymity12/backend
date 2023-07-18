package com.xj.family.bean;


public class CommitRedisView {
    String simplifiedDateString;
    int count;

    public String getSimplifiedDateString() {
        return simplifiedDateString;
    }

    public void setSimplifiedDateString(String simplifiedDateString) {
        this.simplifiedDateString = simplifiedDateString;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CommitRedisView{" +
                "simplifiedDateString='" + simplifiedDateString + '\'' +
                ", count=" + count +
                '}';
    }
}
