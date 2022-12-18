package com.group13.footballer.Exceptions;

public class MatchNotFound extends RuntimeException{

    public MatchNotFound (String message) {
        super(message);
    }
}

