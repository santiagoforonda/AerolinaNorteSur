package com.proyectowed.proyectowed.Excepciones;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExcepcion {

    @ExceptionHandler(UserNotFound.class)
    public  ResponseEntity<ErrorResponse> userNotFound(UserNotFound user, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.NOT_FOUND.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    @ExceptionHandler(DuplicatedBooking.class)
    public ResponseEntity<ErrorResponse> bookingDuplicated(DuplicatedBooking duplicated, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.CONFLICT.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }

    @ExceptionHandler(SeaCpacityFull.class)
    public ResponseEntity<ErrorResponse> seaCapacityFull( SeaCpacityFull full, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.CONFLICT.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);

    }

    @ExceptionHandler(BookingNotCheckedIn.class)
    public ResponseEntity<ErrorResponse> bookingNotCheck( BookingNotCheckedIn book, WebRequest wr){
        ErrorResponse respuesta = new ErrorResponse();
        respuesta.setErrorCode(HttpStatus.CONFLICT.value());
        respuesta.setTime(LocalDateTime.now());
        respuesta.setDescripcion(wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(respuesta);
    }
}
