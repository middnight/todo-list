package com.todo.list.todo_list.service;

import com.todo.list.todo_list.model.Task;
import com.todo.list.todo_list.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    public Task create(Task task){
        task.setId(null);
        return taskRepository.save(task);

    }


    public Task update(Long id, Task newTask){
        Task task=findById(id);
        newTask.setId(task.getId());
        newTask.setCreatedAt(task.getCreatedAt());
        return taskRepository.save(newTask);
    }


    public Task findById(Long id){
        if(taskRepository.existsById(id)){
            return taskRepository.findById(id).get();
        }
            throw new RuntimeException("Given TaskId Does Not Exists");

    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }

}
