package com.proyectowed.proyectowed.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyectowed.proyectowed.Entities.Flight;

@Repository
public interface  FlightRepository extends JpaRepository<Flight,Long> {

    @Query("SELECT f FROM Flight f WHERE f.departureAirportCode = ?1 AND f.arrivalAirportCode = ?2 AND f.departureDate = ?3")
    List<Flight> findByDAirportCodeAairpotCodeDdate(String departureAirportCode, String arrivalAirportCode, Date departureDate);

    @Query("SELECT f FROM Flight f WHERE f.departureDate = ?1 AND f.departureAirportCode = ?2")
    List<Flight> findBydepartureDateAndAirportCode(Date departureDate, String airportCode);
}
