package com.taskbot.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bot_command_logging")
public class BotCommandLogging {

    @Id
    private Long id;

    @Column(name = "telegram_id")
    private Long telegramId;

    private String command;

    @Column(name = "raw_message")
    private String rawMessage;

    @Column(name = "response_message")
    private String responseMessage;

    @Column(name = "execution_status")
    private String executionStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}