package com.taskmanager.taskmanagementsystem.repository;

import com.taskmanager.taskmanagementsystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}