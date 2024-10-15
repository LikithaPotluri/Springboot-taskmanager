package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task; 
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    private long nextId = 1; // Variable to track the next available ID

    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        task.setId(nextId++); // Assign the current nextId and increment it
        tasks.add(task);
        return task;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.set(i, updatedTask);
                return updatedTask;
            }
        }
        return null; // Or throw an exception
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
