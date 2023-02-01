package com.xj.family.service;

import com.xj.family.bean.Task;
import com.xj.family.bean.User;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.mapper.TaskMapper;
import com.xj.family.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskMapper taskMapper;

    public List<Task> getAllTask() {
        int ownerId = LoginInterceptor.threadLocalUserId.get();
        System.out.println("task service got user id: " + ownerId);
        return taskMapper.getAllTasksByOwner(ownerId);
    }
}
