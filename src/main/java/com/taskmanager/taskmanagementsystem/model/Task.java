package com.taskmanager.taskmanagementsystem.model;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Usamos la estrategia "JOINED" para herencia.
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Relación con la entidad User (Un usuario puede tener muchas tareas)

    @OneToMany(mappedBy = "task")
    private List<SubTask> subTasks;  // Relación con SubTask

    // Getters y Setters :)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }
}