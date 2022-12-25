package com.xj.family.mapper;

import com.xj.family.bean.Role;
import com.xj.family.bean.Hr;

import java.util.List;


public interface HrMapper {

    List<Role> getHrRolesById(Integer id);

    Hr loadUserByUsername(String username);
}