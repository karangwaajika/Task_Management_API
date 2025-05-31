package com.lab.task_management_api.controller;

import com.lab.task_management_api.model.Task;
import com.lab.task_management_api.service.TaskService;
import com.lab.task_management_api.service.impl.TaskServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(name = "add_task", path = "")
    public Map<String, String> createTask(@RequestBody Task task){
        taskService.createTask(task);

        return Map.of("message", "Task created successfully");
    }
}
