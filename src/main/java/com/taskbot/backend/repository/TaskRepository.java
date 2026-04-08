package com.taskbot.backend.repository;

import com.taskbot.backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(String status);

    List<Task> findByAssignedToId(Long userId);

    List<Task> findByCreatedById(Long userId);
}