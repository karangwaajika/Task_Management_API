package com.lab.task_management_api.dao;

import com.lab.task_management_api.TestDataUtil;
import com.lab.task_management_api.dao.impl.TaskDaoImpl;
import com.lab.task_management_api.model.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TaskDaoTest {
    private final TaskDaoImpl taskDaoImpl;

    @Autowired
    public TaskDaoTest(TaskDaoImpl taskDaoImpl) {
        this.taskDaoImpl = taskDaoImpl;
    }

    @Test
    public void testTaskAddToTheCollection(){
        Task task = TestDataUtil.createTask1();
        taskDaoImpl.create(task);
        Optional<Task> result = taskDaoImpl.findOne(task.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(task);
    }

//    @Test
//    public void testUpdateTaskShouldReturnTheUpdatedTask(){
//        Task task = TestDataUtil.createTask1();
//        taskDaoImpl.create(task);
//        // i need to retrieve the one in collection first
//        task.setTitle("New title");
//
//        Task result = taskDaoImpl.update(task);
//        assertThat(result).isEqualTo(task);
//
//    }

    @Test
    public void testUpdateTaskProgressShouldReturnTheUpdatedTask(){
        Task task = TestDataUtil.createTask1();
        taskDaoImpl.create(task);

        task.setStatus(3);

        Task result = taskDaoImpl.updateProgress(task.getId(), 3);
        assertThat(result).isEqualTo(task);

    }
}
