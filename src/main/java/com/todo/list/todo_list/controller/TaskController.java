package com.todo.list.todo_list.controller;

import com.todo.list.todo_list.model.Task;
import com.todo.list.todo_list.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    @PostMapping
    public Task createTask(@RequestBody Task task){
        task.setId(null);
         return taskService.save(task);
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task newTask){
        return taskService.update(id,newTask);
    }

    @DeleteMapping("/{id}")
    public Task delete(@PathVariable Long id){
        return taskService.delete(id);
    }
}
