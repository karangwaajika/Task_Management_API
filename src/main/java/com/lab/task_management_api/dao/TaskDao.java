package com.lab.task_management_api.dao;

import com.lab.task_management_api.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskDao {
    void create(Task task);
    Optional<Task> findOne(int taskId);
    List<Task> findAll();
    Task update(Task task);
    Task updateProgress(int taskId, int status);
    List<Task> filterStatus(int status);
    Task delete(int taskId);

}
