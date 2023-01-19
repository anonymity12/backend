package com.xj.family.service;

import com.xj.family.mapper.FamilyTreeMapper;
import com.xj.family.bean.FamilyTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyTreeService {
    @Autowired
    FamilyTreeMapper familyTreeMapper;

    public List<FamilyTreeEntity> list() {
        return familyTreeMapper.list();
    }
}