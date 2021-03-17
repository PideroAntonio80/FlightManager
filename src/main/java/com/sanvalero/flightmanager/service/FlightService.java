package com.sanvalero.flightmanager.service;

import com.sanvalero.flightmanager.domain.Flight;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Creado por @ author: Pedro Orós
 * el 15/03/2021
 */
public interface FlightService {

    Flux<Flight> findAll();
    Mono<Flight> findById(String id);
    Flux<Flight> findByOrigin(String origin);
    Flux<Flight> findByDestination(String destination);
    Flux<Flight> findByScales(int scales);
    Mono<Flight> addFlight(Flight flight);
    Mono<Flight> modifyflight(String id, Flight flight);
    void deleteFlight(String id);
    void deleteFlightsByDestination(String destination);
}
