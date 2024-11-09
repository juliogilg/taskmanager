package com.taskmanager.taskmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<com.taskmanager.taskmanagementsystem.repository.Task, Long> {
}