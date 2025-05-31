package com.lab.task_management_api.exception;

public class InvalidTaskStatusException extends TaskException{
    public InvalidTaskStatusException(String message) {
        super(message);
    }
}
