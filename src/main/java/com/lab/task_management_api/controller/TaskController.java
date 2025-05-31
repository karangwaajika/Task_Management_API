package com.lab.task_management_api.controller;

import com.lab.task_management_api.model.Task;
import com.lab.task_management_api.service.TaskService;
import com.lab.task_management_api.service.impl.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping(name = "view_tasks", path = "")
    public List<Task> viewAllTasks(){
        return this.taskService.retrieveAllTasks();
    }

    @GetMapping(name = "view_one_task", path = "/{id}")
    public Optional<Task> viewOneTask(@PathVariable int id){
        return this.taskService.retrieveTask(id);
    }

    @PutMapping(name = "update_task", path = "/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable int id){
        System.out.println(task);
        return taskService.updateTask(task, id);
    }

}
