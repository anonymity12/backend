package com.xj.family.service;

import com.xj.family.mapper.PostMapper;
import com.xj.family.bean.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class PostService {
    @Autowired
    PostMapper postMapper;

    public List<Post> getAll() {
        return postMapper.getAll();
    }
    public int add(Post post) {
        return postMapper.insert(post);
    }
}