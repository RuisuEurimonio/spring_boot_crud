package com.ruisu.todo_list.service.DTO;

import com.ruisu.todo_list.persistence.entity.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private String title;
    private String description;
    private LocalDateTime eta;
}
