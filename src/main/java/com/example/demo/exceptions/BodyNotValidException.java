package com.example.demo.exceptions;

public class BodyNotValidException extends RuntimeException {

    public BodyNotValidException(String message) {
        super(message);
    }

}