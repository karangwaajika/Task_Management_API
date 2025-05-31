package com.lab.task_management_api.service;

import com.lab.task_management_api.dao.TaskDao;
import com.lab.task_management_api.model.Task;

import java.util.List;
import java.util.Optional;

public class TaskService {
    TaskDao taskDao;

    public TaskService(TaskDao taskDao){
        this.taskDao = taskDao;
    }

    public void createTask(Task task){
        this.taskDao.create(task);
    }

    public Optional<Task> retrieveTask(int taskId){
        return taskDao.findOne(taskId);
    }

    public List<Task> retrieveAllTasks(){
        return taskDao.findAll();
    }

    public Task updateTask(Task task){
        return taskDao.update(task);
    }

    public Task updateTaskProgress(int taskId, int status){
        return taskDao.updateProgress(taskId, status);
    }

    public List<Task> filterTaskStatus(int status){
        return taskDao.filterStatus(status);
    }


}
