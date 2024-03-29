package com.xj.family.mapper;

import com.xj.family.bean.Routine;

import java.util.List;

public interface RoutineMapper {
    List<Routine> queryAllUsersRoutines();

    List<Routine> queryAllRoutineForUser(int userId);

    int addRoutine(Routine routine);

    int updateRoutine(Routine routine);

    int deleteRoutine(Integer routineId);
}
