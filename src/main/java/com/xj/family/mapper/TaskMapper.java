package com.xj.family.mapper;

import com.xj.family.bean.Task;
import com.xj.family.bean.dto.TaskDto;

import java.util.List;

public interface TaskMapper {
    List<Task> getAllTasksByOwner(int owner);

    int addTask(Task task);

    int addRoutineTask(Task task);

    int cancelTask(int id);

    int doneTask(TaskDto dto);// an update will return 1 when matched(no matter updated or not)

    int releaseFly(int id);

    int toggleFly(int status, int id);

    List<Task> queryRoutines();
}
