package com.proyectowed.proyectowed.Excepciones;

public class UserNotFound extends RuntimeException{
    String message;

    public UserNotFound(){
        super("User not found");
    }

    public UserNotFound(String message){
        this.message = message;
    }

}
