package com.lab.task_management_api.config;

import com.lab.task_management_api.model.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseConfig {
    @Bean
    public List<Task> database(){
        return new ArrayList<>();
    }
}
