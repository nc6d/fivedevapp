package com.five.auth.exception;

public class UserAlreadyRegisteredException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public UserAlreadyRegisteredException(String message) {
        super(message);
    }
}
