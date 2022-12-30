package com.group13.footballer.core.Exceptions;

public class TeamNotFound extends RuntimeException{
    public TeamNotFound(String message){
        super(message);
    }
}
