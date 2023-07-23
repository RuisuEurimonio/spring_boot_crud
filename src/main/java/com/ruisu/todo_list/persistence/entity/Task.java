package com.ruisu.todo_list.persistence.entity;

import lombok.Data;
import org.hibernate.boot.registry.selector.StrategyRegistration;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus status;

}