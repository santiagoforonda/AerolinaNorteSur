package com.proyectowed.proyectowed.Dtos.FlightDtos;

import java.util.Date;

import lombok.Data;

@Data
public class FlightDto {

    private Date departureDate;
    private String departureAirportCode;
    private String departureAirportDate;
    private String departureAirpotName;
    private String departureCity;
    private String departureLocale;
    private Date arrivalDate;
    private String arrivalAirportCode;
    private String arrivalAirportName;
    private String arrivalCity;
    private String arrivalLocale;
    private Long ticketPrice;
    private String ticketCurrency;
    private int flightNumber;
    private int seaCapacity;


}
