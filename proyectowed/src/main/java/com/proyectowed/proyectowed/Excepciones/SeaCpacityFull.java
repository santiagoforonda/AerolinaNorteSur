package com.proyectowed.proyectowed.Excepciones;

public class SeaCpacityFull extends RuntimeException{
    String message;

    public SeaCpacityFull(){
        super("SeaCapacity is full");
    }

    public SeaCpacityFull(String message){
        this.message=message;
    }
}
