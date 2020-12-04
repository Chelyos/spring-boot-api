package com.api.api.controller;

import com.api.api.service.TaskService;
import com.api.api.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public void createTask(@RequestBody Task task, @RequestParam("id") Long id) {
        taskService.saveTask(task, id);
    }

    @GetMapping("/task")
    public List<Task> getTask(@RequestParam("id") final Long id) {
        return taskService.getTask(id);
    }

    @DeleteMapping("/task")
    public void deleteTask(@RequestParam("taskId") Long taskId, @RequestParam("userId") Long userId) {
        taskService.deleteTask(taskId, userId);
    }
}