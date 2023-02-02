package com.xj.family.service;

import com.xj.family.bean.FlyItem;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.Task;
import com.xj.family.bean.User;
import com.xj.family.bean.dto.TaskDto;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.mapper.FlyItemMapper;
import com.xj.family.mapper.TaskMapper;
import com.xj.family.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final String taskFlyName = "任务蝶";
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    FlyItemMapper flyItemMapper;

    public List<Task> getAllTask() {
        int ownerId = LoginInterceptor.threadLocalUserId.get();
        System.out.println("task service got user id: " + ownerId);
        return taskMapper.getAllTasksByOwner(ownerId);
    }

    public RespBean addTask(Task task) {

        int owner = LoginInterceptor.threadLocalUserId.get();
        FlyItem flyItem = new FlyItem();
        flyItem.setOwner(owner);
        flyItem.setName(taskFlyName);
        flyItem.setEvaluate(task.getTitle());
        flyItem.setStatus(0);
        flyItemMapper.addForTaskCreated(flyItem);
        long flyId = flyItem.getId();

        task.setOwner(owner);
        task.setFlyId(flyId);
        int ret = taskMapper.addTask(task);
        if (ret == 1) {
            return RespBean.ok("添加任务OK");
        }
        else {
            return RespBean.error("添加任务失败了");
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
