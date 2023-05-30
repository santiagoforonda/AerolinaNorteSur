package com.proyectowed.proyectowed.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyectowed.proyectowed.Entities.Flight;
import com.proyectowed.proyectowed.Repositories.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {


    private final FlightRepository vueloRepo;

    @Autowired
    public FlightServiceImpl(FlightRepository vueloRepo){
        this.vueloRepo=vueloRepo;
    }


    @Override
    public Flight create(Flight vuelo) {
        Flight copy= new Flight(null,vuelo.getDepartureDate(),vuelo.getDepartureAirportCode(),vuelo.getDepartureAirportDate(),vuelo.getDepartureAirportName(),vuelo.getDepartureCity(),vuelo.getDepartureLocale(),vuelo.getArrivalDate(),vuelo.getArrivalAirportCode(),vuelo.getArrivalAirportName(),vuelo.getArrivalCity(),vuelo.getArrivalLocale(),vuelo.getTicketPrice(),vuelo.getTicketCurrency(),vuelo.getFlightNumber(),vuelo.getSeaCapacity());
        return vueloRepo.save(copy);
    }

    @Override
    public List<Flight> findByDAirportCodeAairpotCodeDdate(String departureAirportCode, String arrivalAirportCode, Date departureDate) {
        return vueloRepo.findByDAirportCodeAairpotCodeDdate(departureAirportCode, arrivalAirportCode,departureDate);
    }

    @Override
    public Optional<Flight> updateById(Long id, Flight fly) {
        return vueloRepo.findById(id).map(vuelito -> {
            Flight vuelo=vuelito.UpdateWidth(fly);
            return vueloRepo.save(vuelo);
        });
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        vueloRepo.deleteById(id);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @Override
    public List<Flight> findBydepartureDateAndAirportCode(String departureAirportCode, Date departureDate) {

        return vueloRepo.findBydepartureDateAndAirportCode(departureDate, departureAirportCode);
    }


}
