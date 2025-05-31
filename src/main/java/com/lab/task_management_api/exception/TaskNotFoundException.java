package com.lab.task_management_api.exception;

public class TaskNotFoundException extends TaskException{
    public TaskNotFoundException(String message) {
        super(message);
    }
}
