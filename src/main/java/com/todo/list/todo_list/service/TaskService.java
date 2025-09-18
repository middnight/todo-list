package com.todo.list.todo_list.service;

import com.todo.list.todo_list.model.Task;
import com.todo.list.todo_list.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    public Task save(Task task){
     return taskRepository.save(task);
    }

    public Task findById(Long id){
         Optional<Task> optionalTask =taskRepository.findById(id);
         if(optionalTask.isEmpty()){
             throw new RuntimeException("Given id is not valid");
         }
         return optionalTask.get();
    }


    public Task update(Long id, Task newTask){
        Task task= findById(id);
        newTask.setCreateAt(task.getCreateAt());
        newTask.setId(task.getId());
        return taskRepository.save(newTask);
    }

    public Task delete(long id){
        if(!taskRepository.existsById(id)){
            throw new RuntimeException(" Given id is not valid");
        }
        Task task=findById(id);
         taskRepository.deleteById(id);
         return task;
    }
}
