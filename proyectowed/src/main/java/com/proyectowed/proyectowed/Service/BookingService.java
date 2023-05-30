package com.proyectowed.proyectowed.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.proyectowed.proyectowed.Entities.Booking;
import com.proyectowed.proyectowed.Entities.BookingStatus;
import com.proyectowed.proyectowed.Entities.Flight;
import com.proyectowed.proyectowed.Entities.User;

public interface BookingService {

    Booking created(Booking reserva);

    List<Booking> findByCustomerName(Long id);
    List<Booking> finByStatus(BookingStatus status);

    Booking createdByUserAndFlight(User usuario, Flight vuelo);

    Optional<Booking> upDateBooking(Long id, Booking oldBooking);
    ResponseEntity<?> deleteBooking(Long id);

    List<Booking> findByFlight(Long id);

    Optional<Booking> findById(Long id);




}
