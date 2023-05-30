package com.xj.family.service;

import com.xj.family.bean.FlyItem;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.Routine;
import com.xj.family.bean.Task;
import com.xj.family.interceptor.LoginInterceptor;
import com.xj.family.mapper.RoutineMapper;
import com.xj.family.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoutineService {

    @Autowired
    RoutineMapper routineMapper;

    public List<Task> transformAllRoutineToTask() {
        List<Task> tasksGenerated = new ArrayList<>();
        List<Routine> routines = routineMapper.queryAllUsersRoutines();
        routines.forEach(it -> {
            Task task = new Task();
            task.setOwner(it.getRoutineOwner());
            task.setTitle(it.getRoutineContent());
            tasksGenerated.add(task);
        });
        return tasksGenerated;
    }


    public List<Routine> queryAllRoutineForUser() {
        int ownerId = LoginInterceptor.threadLocalUserId.get();
        return routineMapper.queryAllRoutineForUser(ownerId);
    }

    public RespBean addRoutineForUser(Routine routine) {
        int ownerId = LoginInterceptor.threadLocalUserId.get();
        routine.setRoutineOwner(ownerId);
        int i = routineMapper.addRoutine(routine);
        if (i>0)
            return RespBean.ok("添加新惯例成功");
        else
            return RespBean.error("添加失败了");
    }

    public RespBean updateRoutineForUser(Routine routine) {
        int ownerId = LoginInterceptor.threadLocalUserId.get();
        routine.setRoutineOwner(ownerId);
        int i = routineMapper.updateRoutine(routine);
        if (i>0)
            return RespBean.ok("更新新惯例成功");
        else
            return RespBean.error("更新失败了");
    }

    public RespBean deleteRoutineById(Integer routineId) {
        int i = routineMapper.deleteRoutine(routineId);
        if (i>0)
            return RespBean.ok("更新新惯例成功");
        else
            return RespBean.error("更新失败了");
    }
}
