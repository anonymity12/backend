package com.xj.family.mapper;

import com.xj.family.bean.LifeIndicator;
import com.xj.family.bean.User;
import java.util.List;

public interface UserMapper {
    Long getUserIdByName(String username);
    User getUserByName(String username);
    LifeIndicator getUserLifeIndicator(Long userId);
    Integer addNewUser(User user);
}