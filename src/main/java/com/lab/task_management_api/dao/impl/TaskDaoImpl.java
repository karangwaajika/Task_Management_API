package com.lab.task_management_api.dao.impl;

import com.lab.task_management_api.dao.TaskDao;
import com.lab.task_management_api.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDaoImpl implements TaskDao {
    private final List<Task> database;
    public TaskDaoImpl(List<Task> database) {
        this.database = database;
    }
    @Override
    public void create(Task task) {
        this.database.add(task);
    }

    @Override
    public Optional<Task> findOne(int taskId) {
        return this.database.stream().filter(task-> task.getId() == taskId).findFirst();
    }

    @Override
    public List<Task> findAll() {
        return this.database;
    }

    @Override
    public Task update(Task task) {
        Optional<Task> oldTask = this.database.stream().filter(old-> old.getId() == task.getId()).findFirst();
        if(oldTask.isEmpty()){
            return null;
        }
        this.database.set(this.database.indexOf(oldTask.get()), task); // update
        return this.database.get(this.database.indexOf(oldTask.get()));
    }

    @Override
    public Task updateProgress(int taskId, int status) {
        Optional<Task> oldTask = this.database.stream().filter(old-> old.getId() == taskId).findFirst();
        oldTask.get().setStatus(status); // update status field
        this.database.set(this.database.indexOf(oldTask.get()), oldTask.get()); // update

        return this.database.get(this.database.indexOf(oldTask.get()));
    }

    @Override
    public List<Task> filterStatus(int status) {
        return this.database.stream().filter(task->task.getStatus() == status).toList();
    }

    @Override
    public Task delete(int taskId) {
        Optional<Task> oldTask = this.database.stream().filter(old-> old.getId() == taskId).findFirst();
        return this.database.remove(this.database.indexOf(oldTask.get()));
    }
}
