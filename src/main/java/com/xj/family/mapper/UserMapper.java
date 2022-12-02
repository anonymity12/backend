package com.xj.family.mapper;

import com.xj.family.bean.User;
import java.util.List;

public interface UserMapper {
    Long getUserIdByName(String username);
    User getUserByName(String username);
}