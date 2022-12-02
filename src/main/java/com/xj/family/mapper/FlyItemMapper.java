package com.xj.family.mapper;

import org.apache.ibatis.annotations.Param;
import com.xj.family.bean.FlyItem;
import java.util.List;

public interface FlyItemMapper {
    int insert(FlyItem item);
    List<FlyItem> getAllItemsForUser(@Param("owner") Long userId);
}
