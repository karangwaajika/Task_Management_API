package com.lab.task_management_api.service.impl;

import com.lab.task_management_api.dao.TaskDao;
import com.lab.task_management_api.model.Task;
import com.lab.task_management_api.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;

    public TaskServiceImpl(TaskDao taskDao){
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

    public Task updateTask(Task task, int taskId){
        Optional<Task> oldTask = taskDao.findOne(taskId);

        oldTask.get().setStatus(task.getStatus());
        oldTask.get().setDescription(task.getDescription());
        oldTask.get().setTitle(task.getTitle());

        return taskDao.update(oldTask.get());
    }

    public Task updateTaskProgress(int taskId, int status){
        return taskDao.updateProgress(taskId, status);
    }

    public List<Task> filterTaskStatus(int status){
        return taskDao.filterStatus(status);
    }

    @Override
    public Task deleteTask(int taskId) {
        return taskDao.delete(taskId);
    }

}
