package com.proyectowed.proyectowed.Entities;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="flights")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Date departureDate;

    @Column(unique = true)
    private String departureAirportCode;

    @Column
    private String departureAirportDate;


    @Column
    private String departureAirportName;

    @Column
    private String departureCity;

    @Column
    private String departureLocale;

    @Column
    private Date arrivalDate;

    @Column(unique = true)
    private String arrivalAirportCode;

    @Column
    private String arrivalAirportName;

    @Column
    private String arrivalCity;

    @Column
    private String arrivalLocale;

    @Column
    private Long ticketPrice;

    @Column
    private String ticketCurrency;

    @Column(unique = true)
    private int flightNumber;

    @Column
    private int seaCapacity;

    public Flight UpdateWidth(Flight vuelo){
    return new Flight(this.id,vuelo.getDepartureDate(),vuelo.getDepartureAirportCode(),vuelo.getDepartureAirportDate(),vuelo.getDepartureAirportName(),vuelo.getDepartureCity(),vuelo.getDepartureLocale(),vuelo.getArrivalDate(),vuelo.getArrivalAirportCode(),vuelo.getArrivalAirportName(),vuelo.getArrivalCity(),vuelo.getArrivalLocale(),vuelo.getTicketPrice(),vuelo.getTicketCurrency(),vuelo.getFlightNumber(),vuelo.getSeaCapacity());

    }

}
