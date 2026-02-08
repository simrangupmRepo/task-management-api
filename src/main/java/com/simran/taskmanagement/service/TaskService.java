package com.simran.taskmanagement.service;

import com.simran.taskmanagement.entity.Task;
import com.simran.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<Task> updateTask(Long id, Task updates) {
        return taskRepository.findById(id)
                .map(task -> {
                    if (updates.getTitle() != null) task.setTitle(updates.getTitle());
                    if (updates.getDescription() != null) task.setDescription(updates.getDescription());
                    if (updates.getStatus() != null) task.setStatus(updates.getStatus());
                    return taskRepository.save(task);
                });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
