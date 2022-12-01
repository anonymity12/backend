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

    public List<FlyItem> getAllItems() {
        return flyItemMapper.getAllItems();
    }

    public int addItem(FlyItem item) {
        int result = flyItemMapper.insert(item);
        return result;
    }
}
