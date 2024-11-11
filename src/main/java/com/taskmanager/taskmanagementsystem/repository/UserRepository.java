package com.taskmanager.taskmanagementsystem.repository;

import com.taskmanager.taskmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}