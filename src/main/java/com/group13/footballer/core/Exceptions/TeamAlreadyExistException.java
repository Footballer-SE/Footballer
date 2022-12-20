package com.group13.footballer.core.Exceptions;

public class TeamAlreadyExistException extends RuntimeException{
    public TeamAlreadyExistException(String message) {
        super(message);
    }
}
