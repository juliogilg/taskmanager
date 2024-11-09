package com.taskmanager.taskmanagementsystem.model;

import jakarta.persistence.Entity;

@Entity
public class SubTask extends Task {

    private String detail;

    // Getters y Setters :)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}