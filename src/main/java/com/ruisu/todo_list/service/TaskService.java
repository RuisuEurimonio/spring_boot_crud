package com.ruisu.todo_list.service;

import com.ruisu.todo_list.Mapper.TaskToDTOToTask;
import com.ruisu.todo_list.exceptions.ToDoExceptions;
import com.ruisu.todo_list.persistence.entity.Task;
import com.ruisu.todo_list.persistence.entity.TaskStatus;
import com.ruisu.todo_list.persistence.repository.TaskRepository;
import com.ruisu.todo_list.service.DTO.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskToDTOToTask mapper;


    public TaskService(TaskRepository repository, TaskToDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskDTO taskDTO) {
        Task task = mapper.map(taskDTO);
        return this.repository.save(task);
    }

    public List<Task> findAllTask(){
        return this.repository.findAll();
    }

    public List<Task> findAllByStatus(TaskStatus status){
        return this.repository.findAllByStatus(status);
    }

    @Transactional
    public void markTaskAsFinished(Long id){
        Optional<Task> task = this.repository.findById(id);
        if(task.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }
        
    public void deleteTaskById(Long id){
        Optional<Task> taskO = this.repository.findById(id);
        if(taskO.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}