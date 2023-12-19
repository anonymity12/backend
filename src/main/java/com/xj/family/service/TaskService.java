package com.xj.family.service;

import com.xj.family.bean.FlyItem;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.Task;
import com.xj.family.bean.User;
import com.xj.family.bean.dto.TaskDto;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.mapper.CardInstanceMapper;
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
    @Autowired
    CardInstanceMapper cardInstanceMapper;
    @Autowired
    GoldMapper goldMapper;

    public List<Task> getAllTask() {
        int ownerId = LoginInterceptor.threadLocalUserId.get();
        System.out.println("task service got user id: " + ownerId);
        return taskMapper.getAllTasksByOwner(ownerId);
    }

    public RespBean addTask(Task task) {
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
        if (ret == 1) { // maybe 2
            return RespBean.ok("任务被取消了");
        }
        else {
            return RespBean.error("无法取消任务");
        }
    }

    public RespBean doneTask(TaskDto dto) {
        int ownerId = LoginInterceptor.threadLocalUserId.get();
        // 1. user got gold when he/she finish task
        goldMapper.addGoldForUser(userId, FINISH_TASK_REWARD);
        // 2. upgrade his/her main card
        int cardInstanceId = cardInstanceMapper.getUserMainCard(ownerId).getId();
        int ret = cardInstanceMapper.upgradeCard(cardInstanceId);
        // 3. mark task is done
        ret += taskMapper.doneTask(dto);
        if (ret == 2) {
            return RespBean.ok("完成任务啦😄"); // two update will make ret==2
        }
        else {
            return RespBean.error("无法完成任务😭");
        }
    }
}
