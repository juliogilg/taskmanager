package com.taskmanager.taskmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SubTask extends Task {

    private String detail;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    // Getters y Setters :)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}