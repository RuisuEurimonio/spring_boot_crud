package com.ruisu.todo_list.controller;

import com.ruisu.todo_list.persistence.entity.Task;
import com.ruisu.todo_list.persistence.entity.TaskStatus;
import com.ruisu.todo_list.service.DTO.TaskDTO;
import com.ruisu.todo_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO){
        return this.taskService.createTask(taskDTO);
    }

    @GetMapping
    public List<Task> findAllTask(){
        return this.taskService.findAllTask();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status){
        return this.taskService.findAllByStatus(status);
    }

    @PatchMapping("/updateStatus/{id}")
    public ResponseEntity<Void> markTaskAsFinished(@PathVariable("id") Long id){
        this.taskService.markTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long id){
        this.taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
