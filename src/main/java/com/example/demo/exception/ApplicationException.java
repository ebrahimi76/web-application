package com.example.demo.exception;

public class ApplicationException extends Exception{
    public ApplicationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
