package com.proyectowed.proyectowed.Controllers;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyectowed.proyectowed.Dtos.FlightDtos.FlightDto;
import com.proyectowed.proyectowed.Dtos.FlightDtos.FlightMapper;
import com.proyectowed.proyectowed.Entities.Flight;
import com.proyectowed.proyectowed.Service.FlightService;
import com.proyectowed.proyectowed.Dtos.FlightDtos.FlightCreatedDto;

@RestController
@RequestMapping("/api/Catalogs")
public class FlightController {


    private FlightService servicio;

    private FlightMapper mapeador;

    @Autowired
    public FlightController(FlightService servicio, FlightMapper mapeador){
        this.servicio=servicio;
        this.mapeador=mapeador;
    }



    @GetMapping("/catalogs")
    public ResponseEntity<List<FlightCreatedDto>> findByManyParameters(@RequestParam("departureAirportCode") String departureAirportCode, @RequestParam String arrivalAirportCode, @RequestParam Date departureDate){
        List<Flight> vuelos = servicio.findByDAirportCodeAairpotCodeDdate(departureAirportCode,arrivalAirportCode,departureDate);
        List<FlightCreatedDto> truVuelos = vuelos.stream().map(v ->  mapeador.toFlightCreatedDto(v)).collect(Collectors.toList());
        return ResponseEntity.ok().body(truVuelos);

    }

    @PostMapping("/catalogs")
    public ResponseEntity<FlightCreatedDto> create (@RequestBody FlightDto fly){
        Flight newFlight = mapeador.toEntity(fly);
        Flight vueloCreado = null;

        vueloCreado = servicio.create(newFlight);
        FlightCreatedDto creadorFlight = mapeador.toFlightCreatedDto(vueloCreado);
        URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(creadorFlight.getId()).toUri();
        return ResponseEntity.created(locacion).body(creadorFlight);
    }

    @PutMapping("/catalogs/{id}")
    public ResponseEntity<FlightCreatedDto> upDate (@PathVariable Long id, @RequestBody FlightDto vuelo){
        Flight flightUpdate = mapeador.toEntity(vuelo);
        return servicio.updateById(id, flightUpdate).map( flightActualizado -> ResponseEntity.ok().body(mapeador.toFlightCreatedDto(flightUpdate))).orElseGet(()->{
            Flight vueloCreado = servicio.create(flightUpdate);
            FlightCreatedDto flgithDtoCreado = mapeador.toFlightCreatedDto(vueloCreado);
            URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(flgithDtoCreado.getId()).toUri();
            return ResponseEntity.created(locacion).body(flgithDtoCreado);
        });
    }

    @DeleteMapping("/catalogs/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        servicio.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/catalogs/{airportCode}")
    public ResponseEntity<List<FlightCreatedDto>> findByDateAndAirport(@PathVariable String airporCode, @RequestParam Date departureDate){
        List<Flight> vuelos = servicio.findBydepartureDateAndAirportCode(airporCode,departureDate);
        List<FlightCreatedDto> truVuelos = vuelos.stream().map(v -> mapeador.toFlightCreatedDto(v)).collect(Collectors.toList());
        return ResponseEntity.ok().body(truVuelos);
    }

}
