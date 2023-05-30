package com.proyectowed.proyectowed.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyectowed.proyectowed.Entities.Booking;
import com.proyectowed.proyectowed.Entities.BookingStatus;
import com.proyectowed.proyectowed.Entities.Flight;
import com.proyectowed.proyectowed.Entities.User;
import com.proyectowed.proyectowed.Repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService{


    private final BookingRepository reservaRepo;

    public BookingServiceImpl(BookingRepository reservaRepo){
        this.reservaRepo=reservaRepo;
    }

    @Override
    public Booking created(Booking reserva) {
        Booking copy = new Booking(null,reserva.getStatus(),reserva.getOutBoundFlight(),reserva.getPaymentToken(),reserva.getCheckedIn(),reserva.getCustomer(),reserva.getCreatedAt(),reserva.getBookingReference());
        return reservaRepo.save(copy);
    }

    @Override
    public List<Booking> findByCustomerName(Long id) {
        return reservaRepo.findByCustomerId(id);
    }

    @Override
    public List<Booking> finByStatus(BookingStatus status) {
        return reservaRepo.findByStatus(status);
    }

    @Override
    public Booking createdByUserAndFlight(User usuario, Flight vuelo) {
        Booking copy = new Booking(usuario,vuelo);
        return reservaRepo.save(copy);
    }

    @Override
    public Optional<Booking> upDateBooking(Long id, Booking oldBooking) {
        return reservaRepo.findById(id).map(reservita ->{
            Booking reserva= reservita.UpdateWidth(oldBooking);
            return reservaRepo.save(reserva);
        });
    }

    @Override
    public ResponseEntity<?> deleteBooking(Long id) {
        reservaRepo.deleteById(id);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @Override
    public List<Booking> findByFlight(Long id) {
        return reservaRepo.findByFlightId(id);
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return reservaRepo.findById(id);
    }
}