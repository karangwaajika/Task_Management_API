package com.lab.task_management_api.dao.impl;

import com.lab.task_management_api.dao.TaskDao;
import com.lab.task_management_api.model.Task;

import java.util.List;

public class TaskDaoImpl implements TaskDao {
    List<Task> database;
    public TaskDaoImpl(List<Task> database) {
        this.database = database;
    }
    @Override
    public void create(Task task) {
        this.database.add(task);
    }
}
