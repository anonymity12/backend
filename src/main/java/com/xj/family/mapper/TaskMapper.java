package com.xj.family.mapper;

import com.xj.family.bean.Task;

import java.util.List;

public interface TaskMapper {
    List<Task> getAllTasksByOwner(int owner);
}
