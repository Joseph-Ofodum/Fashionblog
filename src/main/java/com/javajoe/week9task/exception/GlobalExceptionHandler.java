package com.javajoe.week9task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(ResourceNotFoundException ex){
        ApiError apiError= new ApiError();
        apiError.setStatus(HttpStatus.NOT_IMPLEMENTED);
        apiError.setMessage(ex.getMessage());
        apiError.setDebugMessage(ex.getDebugMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

}

