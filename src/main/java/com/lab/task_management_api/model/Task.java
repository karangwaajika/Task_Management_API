package com.lab.task_management_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    private int id;
    private String title;
    private String description;
    private int status; // 1: not started, 2: on going, 3: completed
}
