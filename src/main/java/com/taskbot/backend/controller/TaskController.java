package com.taskbot.backend.controller;

import com.taskbot.backend.entity.Task;
import com.taskbot.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> getByStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }

    @GetMapping("/assigned/{userId}")
    public List<Task> getByAssignedUser(@PathVariable Long userId) {
        return service.getByAssignedUser(userId);
    }

    @GetMapping("/created/{userId}")
    public List<Task> getByCreatedUser(@PathVariable Long userId) {
        return service.getByCreatedUser(userId);
    }
}