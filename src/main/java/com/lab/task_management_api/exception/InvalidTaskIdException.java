package com.lab.task_management_api.exception;

public class InvalidTaskIdException extends TaskException{
    public InvalidTaskIdException(String message) {
        super(message);
    }
}
