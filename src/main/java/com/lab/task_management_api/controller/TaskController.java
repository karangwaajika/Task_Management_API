package com.lab.task_management_api.controller;

import com.lab.task_management_api.exception.InvalidTaskIdException;
import com.lab.task_management_api.exception.InvalidTaskStatusException;
import com.lab.task_management_api.exception.TaskExistException;
import com.lab.task_management_api.exception.TaskFieldNotEmptyException;
import com.lab.task_management_api.model.Task;
import com.lab.task_management_api.service.TaskService;
import com.lab.task_management_api.service.impl.TaskServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
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
        try{
            if(task.getTitle().isBlank()){
                throw new TaskFieldNotEmptyException("Title cannot be empty");
            }
            if(task.getDescription().isBlank()){
                throw new TaskFieldNotEmptyException("Description cannot be empty");
            }
            if(task.getId() <= 0){
                throw new InvalidTaskIdException("Id cannot less than or equal to zero");
            }
            if(task.getStatus() <= 0 || task.getStatus() > 3){
                throw new InvalidTaskStatusException("status must be between 1 and 3");
            }
            this.taskService.createTask(task);
        }catch (TaskFieldNotEmptyException | InvalidTaskIdException |
                InvalidTaskStatusException | TaskExistException e){
           return Map.of("error", e.getMessage());
        }

        return Map.of("message", "Task created successfully");
    }

    @GetMapping(name = "view_tasks", path = "")
    public List<Task> viewAllTasks(){
        return this.taskService.retrieveAllTasks();
    }

    @GetMapping(name = "view_one_task", path = "/{id}")
    public ResponseEntity<?> viewOneTask(@PathVariable int id){
        Optional<Task> task = this.taskService.retrieveTask(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping(name = "update_task", path = "/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable int id){
        return this.taskService.updateTask(task, id);
    }

    @PutMapping(name = "update_task_progress", path = "/progress")
    public Task updateTaskProgress(@RequestParam int taskId, @RequestParam int status){
        return this.taskService.updateTaskProgress(taskId, status);
    }

    @GetMapping(name = "filter_task", path = "/status/{status}")
    public List<Task> filterTask(@PathVariable int status){
        return this.taskService.filterTaskStatus(status);
    }

    @DeleteMapping(name = "delete_task", path = "/{id}")
    public Task deleteTask(@PathVariable int id){
        return this.taskService.deleteTask(id);
    }

}
