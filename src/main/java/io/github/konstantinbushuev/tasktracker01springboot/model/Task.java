package io.github.konstantinbushuev.tasktracker01springboot.model;

import java.time.LocalDateTime;

public record Task(
        Long id,
        String title,
        String description,
        TaskStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {}