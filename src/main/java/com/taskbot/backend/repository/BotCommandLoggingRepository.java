package com.taskbot.backend.repository;

import com.taskbot.backend.entity.BotCommandLogging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotCommandLoggingRepository extends JpaRepository<BotCommandLogging, Long> {
}