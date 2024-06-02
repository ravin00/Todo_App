package com.codespecialist.controlers;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codespecialist.models.Task;
import com.codespecialist.repositories.TaskRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tasks")

public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> list() {
        return taskRepository.findAll();
    }

    @GetMapping("{id}")
    public Task getTask(@PathVariable Long id) {

        return taskRepository.getById(id);

    }

    @DeleteMapping

    public void deleteTask(@PathVariable Long id) {
        taskRepository.getById(id);
    }

    @PostMapping
    public Task addTask(@RequestBody String content) {

        return taskRepository.saveAndFlush(new Task(content));
    }

    @PutMapping("{id}") // Correct syntax: PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task currentTask = taskRepository.getById(id);
        BeanUtils.copyProperties(task, currentTask, "task_id");
        return taskRepository.saveAndFlush(currentTask);
    }

}
