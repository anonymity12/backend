package com.xj.family.controller;

import com.xj.family.service.PostService;
import com.xj.family.service.UserService;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/posts")
// this controller is not in use 2023-03-29 22:17:08
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<Post> getAll() {
        return postService.getAll();
    }

    @PostMapping("/{username}/newPost") 
    public RespBean addPost(@RequestBody Post post, @PathVariable("username") String name) {
        Post newPost = new Post();
        Long owner = userService.getUserIdByName(name);
        newPost.setUserId(owner);
        newPost.setCreateTime(new Date());
        newPost.setContent(post.getContent());
        if (postService.add(newPost) == 1) {
            return RespBean.ok("发布了新帖子");
        } else {
            return RespBean.error("帖子发布失败");
        }
    }
}