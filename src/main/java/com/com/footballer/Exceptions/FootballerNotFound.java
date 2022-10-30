package com.group13.footballer.Exceptions;

import com.group13.footballer.Models.FootballTeam;

public class FootballerNotFound extends RuntimeException{
    public FootballerNotFound(String message){
        super(message);
    }
}
