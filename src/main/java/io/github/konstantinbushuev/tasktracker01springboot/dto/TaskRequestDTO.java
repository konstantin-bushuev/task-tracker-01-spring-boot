package io.github.konstantinbushuev.tasktracker01springboot.dto;

public record TaskRequestDTO(
        String title,
        String description
) {}
