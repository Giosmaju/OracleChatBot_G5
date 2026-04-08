package com.taskbot.backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    private Long id;

    private String name;
    private String email;

    @Column(name = "telegram_id")
    private String telegramId;

    private String role;

    @Column(name = "work_mode")
    private String workMode;

    @Column(name = "is_active")
    private Integer isActive;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @JsonManagedReference(value = "assignedTasks")
    @OneToMany(mappedBy = "assignedTo")
    private List<Task> assignedTasks;

    @JsonManagedReference(value = "createdTasks")
    @OneToMany(mappedBy = "createdBy")
    private List<Task> createdTasks;
}