package com.xj.family.bean;

public class Say {
    private Long id;
    private String content;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "Say [content=" + content + ", id=" + id + "]";
    }
}
