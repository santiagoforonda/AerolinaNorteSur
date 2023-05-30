package com.proyectowed.proyectowed.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.proyectowed.proyectowed.Entities.Flight;

public interface FlightService {


    Flight create(Flight vuelo);

    List<Flight> findByDAirportCodeAairpotCodeDdate(String departureAirportCode, String arrivalAirportCode, Date departureDate);

    Optional<Flight> updateById(Long id, Flight fly);

    ResponseEntity<?> delete(Long id);

    List<Flight> findBydepartureDateAndAirportCode(String departureAirportCode, Date departureDate);

}
