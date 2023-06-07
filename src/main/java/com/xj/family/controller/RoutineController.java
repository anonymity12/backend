package com.xj.family.controller;


import com.xj.family.bean.RespBean;
import com.xj.family.bean.Routine;
import com.xj.family.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/routine")
public class RoutineController {
    @Autowired
    RoutineService routineService;
    @GetMapping("/queryAll")
    public List<Routine> queryAll() {
        return routineService.queryAllRoutineForUser();
    }
    @PostMapping("/addRoutine")
    public RespBean addRoutine(@RequestBody Routine routine) {
        System.out.println("adding routine is: " + routine);
        return routineService.addRoutineForUser(routine);
    }
    @PostMapping("/updateRoutine")
    public RespBean updateRoutine(@RequestBody Routine routine) {
        System.out.println("updating routine is: " + routine);
        return routineService.updateRoutineForUser(routine);
    }

    // bug : Integer is not pass to here
    @DeleteMapping("/deleteRoutine/{id}")
    public RespBean deleteRoutine(@PathVariable("id") Integer routineId) {
        System.out.println("delete routineId is:" + routineId);
        return routineService.deleteRoutineById(routineId);
    }

}
