package io.github.konstantinbushuev.tasktracker01springboot.controller;

import io.github.konstantinbushuev.tasktracker01springboot.dto.TaskRequestDTO;
import io.github.konstantinbushuev.tasktracker01springboot.model.Task;
import io.github.konstantinbushuev.tasktracker01springboot.service.TaskService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping
    public Task createTask(@RequestBody TaskRequestDTO request) {
        return taskService.createTask(request);
    }
}
