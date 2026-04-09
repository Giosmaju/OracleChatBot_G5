package com.taskbot.backend;

import com.taskbot.backend.entity.Task;
import com.taskbot.backend.entity.User;
import com.taskbot.backend.repository.TaskRepository;
import com.taskbot.backend.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    @Test
    void testSaveAndRetrieveTaskFromDatabase() {

        taskRepo.deleteAll();
        userRepo.deleteAll();

        // CREATE USER
        User user = new User();
        user.setName("Valeria Cruz");
        user.setEmail("valeria.cruz+" + System.currentTimeMillis() + "@test.com"); // unique
        user.setTelegramId("789321");
        user.setRole("MANAGER");
        user.setWorkMode("HYBRID");
        user.setIsActive(1);
        user.setPasswordHash("securePass987");

        User savedUser = userRepo.save(user);

        // CREATE TASK
        Task task = new Task();
        task.setTitle("Design database schema");
        task.setDescription("Create and optimize the relational model for task management");
        task.setStatus("IN_PROGRESS");
        task.setPriority("MEDIUM");
        task.setVector("BACKLOG");

        task.setAssignedTo(savedUser);
        task.setCreatedBy(savedUser);

        Task savedTask = taskRepo.save(task);

        // READ FROM DB
        List<Task> tasks = taskRepo.findAll();

        // ASSERTIONS
        assertNotNull(savedTask.getId());
        assertEquals(1, tasks.size());
        assertEquals("Design database schema", tasks.get(0).getTitle());
        assertEquals("Valeria Cruz", tasks.get(0).getAssignedTo().getName());
    }
}