package com.xj.family.bean;

import java.util.List;

public class FamilyTreeEntity {
    private Long leafId;
    private Long parentId;
    private String name;// the cname in user table
    private List<FamilyTreeEntity> children;
}