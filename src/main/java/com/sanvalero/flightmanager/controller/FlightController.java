package com.sanvalero.flightmanager.controller;

import com.sanvalero.flightmanager.domain.Flight;
import com.sanvalero.flightmanager.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.websocket.server.PathParam;
import java.util.Objects;

/**
 * Creado por @ author: Pedro Orós
 * el 15/03/2021
 */

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping(value = "/flights", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Flight> getFlights() {
        return flightService.findAll();
    }

    @GetMapping("/flights/{id}")
    public Mono<Flight> getFlightById(@PathVariable String id) {
        return flightService.findById(id);
    }

    @PostMapping("/flights")
    public Mono<Flight> addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @PutMapping("/flights/{id}")
    public Mono<Flight> modifyFlight(@PathVariable String id, @RequestBody Flight newFlight) {
        return flightService.modifyflight(id, newFlight);
    }

    @DeleteMapping("/flights/{id}")
    public void deleteFlight(@PathVariable String id) {
        flightService.deleteFlight(id);
    }

    @DeleteMapping("/flights")
    public void deleteFlightsByDestination(@PathParam(value = "destination") String destination) {
        flightService.deleteFlight(destination);
    }
}
