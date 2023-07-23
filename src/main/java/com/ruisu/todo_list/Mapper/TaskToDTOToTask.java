package com.ruisu.todo_list.Mapper;

import com.ruisu.todo_list.persistence.entity.Task;
import com.ruisu.todo_list.persistence.entity.TaskStatus;
import com.ruisu.todo_list.service.DTO.TaskDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskToDTOToTask implements IMapper<TaskDTO, Task> {


    @Override
    public Task map(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setEta(taskDTO.getEta());
        task.setFinished(false);
        task.setCreateDate(LocalDateTime.now());
        task.setStatus(TaskStatus.ON_TIME);
        return task;
    }
}
