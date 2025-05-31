package com.lab.task_management_api.exception;

public class TaskExistException extends TaskException{
    public TaskExistException(String message) {
        super(message);
    }
}
