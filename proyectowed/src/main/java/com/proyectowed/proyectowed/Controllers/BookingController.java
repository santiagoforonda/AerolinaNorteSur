package com.proyectowed.proyectowed.Controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyectowed.proyectowed.Dtos.BookingDtos.BookingCreatedDto;
import com.proyectowed.proyectowed.Dtos.BookingDtos.BookingDto;
import com.proyectowed.proyectowed.Dtos.BookingDtos.BookingMapper;
import com.proyectowed.proyectowed.Entities.Booking;
import com.proyectowed.proyectowed.Entities.BookingStatus;
import com.proyectowed.proyectowed.Entities.Flight;
import com.proyectowed.proyectowed.Entities.User;
import com.proyectowed.proyectowed.Service.BookingService;

@RestController
@RequestMapping("/api/Bookings")
public class BookingController {

    private BookingService servicio;
    private BookingMapper mapeador;

    public BookingController(BookingService servicio, BookingMapper mapeador) {
        this.servicio=servicio;
        this.mapeador=mapeador;
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<BookingCreatedDto> findById(@PathVariable Long id){
        BookingCreatedDto reservaCreada = servicio.findById(id).map(b -> mapeador.toBookingCreatred(b)).orElseThrow();
        return ResponseEntity.status(HttpStatus.FOUND).body(reservaCreada);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingCreatedDto>> finByStatus (@RequestParam("status") BookingStatus status){
        List<Booking> reservas = servicio.finByStatus(status);
        List<BookingCreatedDto> truReservas = reservas.stream().map(b-> mapeador.toBookingCreatred(b)).collect(Collectors.toList());
        return ResponseEntity.ok().body(truReservas);
    }

    @PostMapping("/bookings/flight/{flightId}/user/{userId}")
    public ResponseEntity<BookingCreatedDto> createByUserAndFlight(@PathVariable("userId") User user, @PathVariable("flightId") Flight vuelo, @RequestBody BookingDto book){
        Booking bookingCreado = null;
        bookingCreado= servicio.createdByUserAndFlight(user,vuelo);
        BookingCreatedDto creadorReserva = mapeador.toBookingCreatred(bookingCreado);
        URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(creadorReserva.getId()).toUri();
        return ResponseEntity.created(locacion).body(creadorReserva);
    }
    @DeleteMapping("bookings/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
        return servicio.deleteBooking(id);
    }

    @GetMapping("bookings/flights/{id}")
    public ResponseEntity<List<BookingCreatedDto>> findByFlight(@PathVariable Flight vuelo){
        List<Booking> reservas = servicio.findByFlight(vuelo.getId());
        List<BookingCreatedDto> truReservas = reservas.stream().map(r -> mapeador.toBookingCreatred(r)).collect(Collectors.toList());
        return ResponseEntity.ok().body(truReservas);
    }
}
