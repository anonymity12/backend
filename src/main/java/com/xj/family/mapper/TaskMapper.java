package com.xj.family.mapper;

import com.xj.family.bean.Task;
import com.xj.family.bean.dto.TaskDto;

import java.util.List;

public interface TaskMapper {
    List<Task> getAllTasksByOwner(int owner);

    int addTask(Task task);

    int cancelTask(int id);

    int doneTask(TaskDto dto);
}
