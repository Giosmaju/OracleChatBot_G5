package com.taskbot.backend.service;

import com.taskbot.backend.entity.Task;
import com.taskbot.backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task save(Task task) {
        return repo.save(task);
    }
}