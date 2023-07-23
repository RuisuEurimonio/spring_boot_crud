package com.ruisu.todo_list.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ToDoExceptions extends RuntimeException{

    public String message;
    public HttpStatus httpStatus;

    public ToDoExceptions(String message, HttpStatus httpStatus){
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
