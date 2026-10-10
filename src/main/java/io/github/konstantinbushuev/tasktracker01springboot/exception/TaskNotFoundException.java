package io.github.konstantinbushuev.tasktracker01springboot.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Task with id " + id + " not found");
    }
}
