package com.lab.task_management_api.dao.impl;

import com.lab.task_management_api.dao.TaskDao;
import com.lab.task_management_api.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskDaoImpl implements TaskDao {
    List<Task> database;
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
}
