package com.xj.family.service;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.Task;
import com.xj.family.bean.User;
import com.xj.family.bean.dto.TaskDto;
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

    public RespBean addTask(Task task) {
        task.setOwner(LoginInterceptor.threadLocalUserId.get());
        int ret = taskMapper.addTask(task);
        if (ret == 1) {
            return RespBean.ok("add task ok!");
        }
        else {
            return RespBean.error("add task failed");
        }
    }

    public RespBean cancelTask(int id) {
        int ret = taskMapper.cancelTask(id);
        if (ret == 1) {
            return RespBean.ok("cancel task ok!");
        }
        else {
            return RespBean.error("cancel task failed");
        }
    }

    public RespBean doneTask(TaskDto dto) {
        int ret = taskMapper.doneTask(dto);
        if (ret == 1) {
            return RespBean.ok("done task ok!");
        }
        else {
            return RespBean.error("done task failed");
        }
    }
}
