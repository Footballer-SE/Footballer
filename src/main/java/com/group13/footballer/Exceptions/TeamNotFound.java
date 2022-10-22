package com.group13.footballer.Exceptions;

public class TeamNotFound extends RuntimeException{
    public TeamNotFound(String message){
        super(message);
    }
}
