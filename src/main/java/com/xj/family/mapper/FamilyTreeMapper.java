package com.xj.family.mapper;

import org.apache.ibatis.annotations.Param;
import com.xj.family.bean.FamilyTreeEntity;

import java.util.List;

public interface FamilyTreeMapper {
    List<FamilyTreeEntity> list();
}