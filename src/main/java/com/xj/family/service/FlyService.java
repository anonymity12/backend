package com.xj.family.service;

import com.xj.family.mapper.FlyItemMapper;
import com.xj.family.bean.FlyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlyService {
    @Autowired
    FlyItemMapper flyItemMapper;
    @Autowired
    UserService userService;

    public List<FlyItem> getAllItemsForUser(String username) {
        long userId = userService.getUserIdByName(username); 
        return flyItemMapper.getAllItemsForUser(userId); 
    }

    public int addItemForUser(FlyItem item, String username) {
        long userId = userService.getUserIdByName(username);
        item.setOwner(userId);
        int result = flyItemMapper.insert(item);
        return result;
    }
}
