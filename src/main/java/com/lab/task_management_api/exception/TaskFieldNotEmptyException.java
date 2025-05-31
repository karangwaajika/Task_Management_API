package com.lab.task_management_api.exception;

public class TaskFieldNotEmptyException extends TaskException{
    public TaskFieldNotEmptyException(String message) {
        super(message);
    }
}
