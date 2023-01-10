package com.javajoe.week9task.exception;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ResourceNotFoundException extends RuntimeException{

    private String debugMessage;

//    public ResourceNotFoundException(String message, String debugMessage) {
//        super(message);
//        this.debugMessage = debugMessage;
//    }
            public ResourceNotFoundException(String message, String debugMessage) {
            super(message);
            this.debugMessage = debugMessage;
        }

    public ResourceNotFoundException(String message){
        super(message);


    }
}
