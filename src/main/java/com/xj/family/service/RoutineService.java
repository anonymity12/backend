package com.xj.family.service;

import com.xj.family.bean.FlyItem;
import com.xj.family.bean.RespBean;
import com.xj.family.bean.Routine;
import com.xj.family.bean.Task;
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
        List<Routine> fake = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fake.add(new Routine("内容"+i, i, i*10));
        }
        return fake;
    }

    public RespBean addRoutineForUser(Routine routine) {
        return RespBean.ok("add faked");
    }

    public RespBean updateRoutineForUser(Routine routine) {
        return RespBean.ok("update faked");
    }

    public RespBean deleteRoutineById(Integer routineId) {
        return RespBean.ok("delete faked");
    }
}
