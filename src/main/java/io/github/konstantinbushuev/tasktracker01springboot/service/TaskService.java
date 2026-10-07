package io.github.konstantinbushuev.tasktracker01springboot.service;

import io.github.konstantinbushuev.tasktracker01springboot.dto.TaskRequestDTO;
import io.github.konstantinbushuev.tasktracker01springboot.model.Task;
import io.github.konstantinbushuev.tasktracker01springboot.model.TaskStatus;
import io.github.konstantinbushuev.tasktracker01springboot.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskRequestDTO request) {
        Long id = taskRepository.nextId();
        LocalDateTime currentTime = LocalDateTime.now();

        Task task = new Task(
                id,
                request.title(),
                request.description(),
                TaskStatus.TODO,
                currentTime,
                currentTime
        );

        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, TaskRequestDTO request) {
        Task initialTask = taskRepository.findById(id).orElse(null);

        if (initialTask == null) {
            return null;
        }

        Task task = new Task(
                id,
                request.title(),
                request.description(),
                initialTask.status(),
                initialTask.createdAt(),
                LocalDateTime.now()
        );

        taskRepository.deleteById(id);

        return taskRepository.save(task);
    }

    public Task completeTask(Long id) {
        Task initialTask = taskRepository.findById(id).orElse(null);

        if (initialTask == null) {
            return null;
        }

        Task task = new Task(
                id,
                initialTask.title(),
                initialTask.description(),
                TaskStatus.DONE,
                initialTask.createdAt(),
                LocalDateTime.now()
        );

        taskRepository.deleteById(id);

        return taskRepository.save(task);
    }

    public boolean deleteTask(Long id) {
        return taskRepository.deleteById(id);
    }

}
