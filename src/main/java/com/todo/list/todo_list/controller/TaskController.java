package com.todo.list.todo_list.controller;

import com.todo.list.todo_list.model.Task;
import com.todo.list.todo_list.repository.TaskRepository;
import com.todo.list.todo_list.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @PostMapping
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id){
        return taskService.findById(id);

    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task newTask){
        return  taskService.update(id,newTask);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        taskService.delete(id);
    }

}
