package com.xj.family.mapper;

import com.xj.family.bean.LifeIndicator;
import com.xj.family.bean.User;
import com.xj.family.bean.dto.ProfileDto;
import com.xj.family.bean.vo.UserAndHisSportScoreInfoVo;

import java.util.List;

public interface UserMapper {
    Long getUserIdByName(String username);
    User getUserByName(String username);
    User getUserById(int userId);
    LifeIndicator getUserLifeIndicator(int userId);
    Integer addNewUser(User user);
    int updateUserProfile(ProfileDto profileDto);
    List<Integer> getRecentlyActiveTenUsersIds();
    UserAndHisSportScoreInfoVo getOtherUserInfo(Integer userId);
}