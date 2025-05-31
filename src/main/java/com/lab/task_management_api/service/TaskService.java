package com.lab.task_management_api.service;

import com.lab.task_management_api.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    void createTask(Task task);
    Optional<Task> retrieveTask(int taskId);
    List<Task> retrieveAllTasks();
    Task updateTask(Task task, int taskId);
    Task updateTaskProgress(int taskId, int status);
    List<Task> filterTaskStatus(int status);
    Task deleteTask(int taskId);
}
