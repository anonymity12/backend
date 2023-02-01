package com.xj.family.controller;

import com.xj.family.bean.RespBean;
import com.xj.family.bean.Task;
import com.xj.family.bean.dto.TaskDto;
import com.xj.family.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/getAll")
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @PostMapping("/add")
    public RespBean addTask(@RequestParam String title) {
        System.out.println("TaskController: addTask: title: " + title);
        Task task = new Task();
        task.setTitle(title);
        return taskService.addTask(task);
    }
    @PostMapping("/cancel")
    public RespBean cancelTask(@RequestParam int taskId) {
        return taskService.cancelTask(taskId);
    }
    @PostMapping("/done")
    public RespBean doneTask(@RequestBody TaskDto dto) {
        return taskService.doneTask(dto);
    }

}
