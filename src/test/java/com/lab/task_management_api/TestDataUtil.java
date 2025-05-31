package com.lab.task_management_api;

import com.lab.task_management_api.model.Task;

public class TestDataUtil {
    public TestDataUtil(){}

    public static Task createTask1(){
        return Task.builder()
                .id(1)
                .title("Do push up")
                .description("Sport")
                .status(1)
                .build();
    }
}
