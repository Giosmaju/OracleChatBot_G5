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

    public Task getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Task save(Task task) {
        return repo.save(task);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Task> getByStatus(String status) {
        return repo.findByStatus(status);
    }

    public List<Task> getByAssignedUser(Long userId) {
        return repo.findByAssignedToId(userId);
    }

    public List<Task> getByCreatedUser(Long userId) {
        return repo.findByCreatedById(userId);
    }
}