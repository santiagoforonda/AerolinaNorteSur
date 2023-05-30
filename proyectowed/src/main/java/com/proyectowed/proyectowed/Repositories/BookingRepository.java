package com.proyectowed.proyectowed.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyectowed.proyectowed.Entities.Booking;
import com.proyectowed.proyectowed.Entities.BookingStatus;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Query("SELECT b FROM Booking b WHERE b.customer.id = ?1")
List<Booking> findByCustomerId(long customerId);


    
    List<Booking> findByStatus(BookingStatus status);

    @Query("SELECT b FROM Booking b WHERE b.outBoundFlight.id = :flightId")
List<Booking> findByFlightId(@Param("flightId") Long flightId);


}

