package com.lab.task_management_api.service;

import com.lab.task_management_api.dao.TaskDao;
import com.lab.task_management_api.model.Task;

public class TaskService {
    TaskDao taskDao;

    public TaskService(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    public void createTask(Task task){
        this.taskDao.create(task);
    }
}
