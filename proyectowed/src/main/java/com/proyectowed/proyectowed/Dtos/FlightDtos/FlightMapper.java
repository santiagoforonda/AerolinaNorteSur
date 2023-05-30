package com.proyectowed.proyectowed.Dtos.FlightDtos;

import org.springframework.stereotype.Component;

import com.proyectowed.proyectowed.Entities.Flight;

@Component
public class FlightMapper {

    public FlightMapper(){

    }

    public FlightDto toDto(Flight vuelo){
        FlightDto vueloDto= new FlightDto();
        vueloDto.setDepartureDate(vuelo.getDepartureDate());
        vueloDto.setDepartureAirportCode(vuelo.getDepartureAirportCode());
        vueloDto.setDepartureAirportDate(vuelo.getDepartureAirportDate());
        vueloDto.setDepartureAirpotName(vuelo.getDepartureAirportName());
        vueloDto.setDepartureCity(vuelo.getDepartureCity());
        vueloDto.setDepartureLocale(vuelo.getDepartureLocale());
        vueloDto.setArrivalDate(vuelo.getArrivalDate());
        vueloDto.setArrivalAirportCode(vuelo.getArrivalAirportCode());
        vueloDto.setDepartureAirpotName(vuelo.getDepartureAirportName());
        vueloDto.setArrivalCity(vuelo.getArrivalCity());
        vueloDto.setArrivalLocale(vuelo.getArrivalLocale());
        vueloDto.setTicketPrice(vuelo.getTicketPrice());
        vueloDto.setTicketCurrency(vuelo.getTicketCurrency());
        vueloDto.setFlightNumber(vuelo.getFlightNumber());
        vueloDto.setSeaCapacity(vuelo.getSeaCapacity());
        return vueloDto;
    }

    public Flight toEntity(FlightDto flightdto){
        Flight vuelo = new Flight();

        vuelo.setDepartureDate(flightdto.getDepartureDate());
        vuelo.setDepartureAirportCode(flightdto.getDepartureAirportCode());
        vuelo.setDepartureAirportDate(flightdto.getDepartureAirportDate());
        vuelo.setDepartureAirportName(flightdto.getDepartureAirpotName());
        vuelo.setDepartureCity(flightdto.getDepartureCity());
        vuelo.setDepartureLocale(flightdto.getDepartureLocale());
        vuelo.setArrivalDate(flightdto.getArrivalDate());
        vuelo.setArrivalAirportCode(flightdto.getArrivalAirportCode());
        vuelo.setDepartureAirportName(flightdto.getDepartureAirpotName());
        vuelo.setArrivalCity(flightdto.getArrivalCity());
        vuelo.setArrivalLocale(flightdto.getArrivalLocale());
        vuelo.setTicketPrice(flightdto.getTicketPrice());
        vuelo.setTicketCurrency(flightdto.getTicketCurrency());
        vuelo.setFlightNumber(flightdto.getFlightNumber());
        vuelo.setSeaCapacity(flightdto.getSeaCapacity());

        return vuelo;
    }


    public FlightCreatedDto toFlightCreatedDto(Flight flight){
        FlightCreatedDto vueloCreado= new FlightCreatedDto();

        vueloCreado.setId(flight.getId());
        vueloCreado.setDepartureDate(flight.getDepartureDate());
        vueloCreado.setDepartureAirportCode(flight.getDepartureAirportCode());
        vueloCreado.setDepartureAirportDate(flight.getDepartureAirportDate());
        vueloCreado.setDepartureAirpotName(flight.getDepartureAirportName());
        vueloCreado.setDepartureCity(flight.getDepartureCity());
        vueloCreado.setDepartureLocale(flight.getDepartureLocale());
        vueloCreado.setArrivalDate(flight.getArrivalDate());
        vueloCreado.setArrivalAirportCode(flight.getArrivalAirportCode());
        vueloCreado.setDepartureAirpotName(flight.getDepartureAirportName());
        vueloCreado.setArrivalCity(flight.getArrivalCity());
        vueloCreado.setArrivalLocale(flight.getArrivalLocale());
        vueloCreado.setTicketPrice(flight.getTicketPrice());
        vueloCreado.setTicketCurrency(flight.getTicketCurrency());
        vueloCreado.setFlightNumber(flight.getFlightNumber());
        vueloCreado.setSeaCapacity(flight.getSeaCapacity());

        return vueloCreado;
    }

    public Flight toFlightEntity(FlightCreatedDto vueloCreadoDto){
        Flight vuelo = new Flight();

        vuelo.setDepartureDate(vueloCreadoDto.getDepartureDate());
        vuelo.setDepartureAirportCode(vueloCreadoDto.getDepartureAirportCode());
        vuelo.setDepartureAirportDate(vueloCreadoDto.getDepartureAirportDate());
        vuelo.setDepartureAirportName(vueloCreadoDto.getDepartureAirpotName());
        vuelo.setDepartureCity(vueloCreadoDto.getDepartureCity());
        vuelo.setDepartureLocale(vueloCreadoDto.getDepartureLocale());
        vuelo.setArrivalDate(vueloCreadoDto.getArrivalDate());
        vuelo.setArrivalAirportCode(vueloCreadoDto.getArrivalAirportCode());
        vuelo.setDepartureAirportName(vueloCreadoDto.getDepartureAirpotName());
        vuelo.setArrivalCity(vueloCreadoDto.getArrivalCity());
        vuelo.setArrivalLocale(vueloCreadoDto.getArrivalLocale());
        vuelo.setTicketPrice(vueloCreadoDto.getTicketPrice());
        vuelo.setTicketCurrency(vueloCreadoDto.getTicketCurrency());
        vuelo.setFlightNumber(vueloCreadoDto.getFlightNumber());
        vuelo.setSeaCapacity(vueloCreadoDto.getSeaCapacity());

        return vuelo;
    }





}
