package com.simran.taskmanagement.repository;

import com.simran.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
