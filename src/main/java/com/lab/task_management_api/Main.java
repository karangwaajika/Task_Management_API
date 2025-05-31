package com.lab.task_management_api;

import com.lab.task_management_api.model.Task;

public class Main {
    public static void main(String[] args) {
        Task task = Task.builder()
                .id(1)
                .title("ajika")
                .description("Nice")
                .status(1)
                .build();
    }
}
