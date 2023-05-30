package com.proyectowed.proyectowed.Excepciones;

public class DuplicatedBooking extends RuntimeException{

    String message;

    public DuplicatedBooking(){
        super("The booking has been duplicated");
    }

    public DuplicatedBooking(String message){
        this.message=message;
    }

}
