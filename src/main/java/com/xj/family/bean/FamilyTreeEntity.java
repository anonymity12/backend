package com.xj.family.bean;

public class FamilyTreeEntity {
    private Long leafId;
    private Long parentId;
    private String name;// the cname in user table
    private List<FamilyTreeEntity> children;
}