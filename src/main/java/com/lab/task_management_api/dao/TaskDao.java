package com.lab.task_management_api.dao;

import com.lab.task_management_api.model.Task;

import java.util.Optional;

public interface TaskDao {
    void create(Task task);
    Optional<Task> findOne(int taskId);
}
