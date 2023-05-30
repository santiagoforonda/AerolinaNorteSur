package com.proyectowed.proyectowed.Dtos.BookingDtos;

import com.proyectowed.proyectowed.Entities.BookingStatus;
import com.proyectowed.proyectowed.Entities.Flight;
import com.proyectowed.proyectowed.Entities.User;

import lombok.Data;

@Data
public class BookingDto {

    private BookingStatus status;
    private Flight outBoundFlight;
    private String paymentToken;
    private Boolean checkedIn;
    private User customer;
    private String createdAt;
    private String bookingReference;
}
