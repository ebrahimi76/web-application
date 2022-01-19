package com.example.demo.exception;

public class LoadException extends RuntimeException{
    public LoadException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
