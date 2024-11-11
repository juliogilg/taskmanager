package com.taskmanager.taskmanagementsystem.service;

import com.taskmanager.taskmanagementsystem.model.Task;
import com.taskmanager.taskmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Obtener todas las tareas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Crear una nueva tarea
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Actualizar una tarea
    public Task updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            return taskRepository.save(task);
        }
        return null;
    }

    // Eliminar una tarea
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}