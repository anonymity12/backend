package com.xj.family.mapper;

import org.apache.ibatis.annotations.Param;
import com.xj.family.bean.Post;
import java.util.List;

public interface PostMapper {
    int insert(Post item);
    List<Post> getAll();
}
