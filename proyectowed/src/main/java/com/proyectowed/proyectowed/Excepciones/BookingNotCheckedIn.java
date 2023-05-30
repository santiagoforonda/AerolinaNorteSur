package com.proyectowed.proyectowed.Excepciones;

public class BookingNotCheckedIn extends RuntimeException{

    String message;

    public BookingNotCheckedIn(){
        super("The booking is not checked in.");
    }

    public BookingNotCheckedIn(String message){
        this.message=message;
    }
}
