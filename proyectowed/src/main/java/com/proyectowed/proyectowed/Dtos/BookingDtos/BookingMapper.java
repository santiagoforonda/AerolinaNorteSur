package com.proyectowed.proyectowed.Dtos.BookingDtos;

import org.springframework.stereotype.Component;

import com.proyectowed.proyectowed.Entities.Booking;

@Component
public class BookingMapper {

    public BookingMapper(){

    }


    public BookingDto toDto(Booking booking){
        BookingDto reservaDto = new BookingDto();

        reservaDto.setStatus(booking.getStatus());
        reservaDto.setOutBoundFlight(booking.getOutBoundFlight());
        reservaDto.setPaymentToken(booking.getPaymentToken());
        reservaDto.setCheckedIn(booking.getCheckedIn());
        reservaDto.setCustomer(booking.getCustomer());
        reservaDto.setCreatedAt(booking.getCreatedAt());
        reservaDto.setBookingReference(booking.getBookingReference());

        return reservaDto;
    }

    public Booking toEntity(BookingDto reservaDto){
        Booking book= new Booking();

        book.setStatus(reservaDto.getStatus());
        book.setOutBoundFlight(reservaDto.getOutBoundFlight());
        book.setPaymentToken(reservaDto.getPaymentToken());
        book.setCheckedIn(reservaDto.getCheckedIn());
        book.setCustomer(reservaDto.getCustomer());
        book.setCreatedAt(reservaDto.getCreatedAt());
        book.setBookingReference(reservaDto.getBookingReference());
        return book;

    }

    public BookingCreatedDto toBookingCreatred(Booking booking){
        BookingCreatedDto reservaDtoCreada = new BookingCreatedDto();

        reservaDtoCreada.setId(booking.getId());
        reservaDtoCreada.setStatus(booking.getStatus());
        reservaDtoCreada.setOutBoundFlight(booking.getOutBoundFlight());
        reservaDtoCreada.setPaymentToken(booking.getPaymentToken());
        reservaDtoCreada.setCheckedIn(booking.getCheckedIn());
        reservaDtoCreada.setCustomer(booking.getCustomer());
        reservaDtoCreada.setCreatedAt(booking.getCreatedAt());
        reservaDtoCreada.setBookingReference(booking.getBookingReference());


        return reservaDtoCreada;
    }

    public Booking toBookingEntity(BookingCreatedDto bookCreado){
        Booking reserva = new Booking();



        reserva.setStatus(bookCreado.getStatus());
        reserva.setOutBoundFlight(bookCreado.getOutBoundFlight());
        reserva.setPaymentToken(bookCreado.getPaymentToken());
        reserva.setCheckedIn(bookCreado.getCheckedIn());
        reserva.setCustomer(bookCreado.getCustomer());
        reserva.setCreatedAt(bookCreado.getCreatedAt());
        reserva.setBookingReference(bookCreado.getBookingReference());

        return reserva;

    }


}
