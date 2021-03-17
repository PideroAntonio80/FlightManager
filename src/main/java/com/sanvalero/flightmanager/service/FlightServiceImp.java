package com.sanvalero.flightmanager.service;

import com.sanvalero.flightmanager.domain.Flight;
import com.sanvalero.flightmanager.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * Creado por @ author: Pedro Orós
 * el 15/03/2021
 */

@Service
public class FlightServiceImp implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flux<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Mono<Flight> findById(String id) {
        return flightRepository.findById(id);
    }

    @Override
    public Flux<Flight> findByOrigin(String origin) {
        return flightRepository.findByOrigin(origin);
    }

    @Override
    public Flux<Flight> findByDestination(String destination) {
        return flightRepository.findByDestination(destination);
    }

    @Override
    public Flux<Flight> findByScales(int scales) {
        return flightRepository.findByScales(scales);
    }

    @Override
    public Mono<Flight> addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Mono<Flight> modifyflight(String id, Flight newFlight) {
        Mono<Flight> flight = flightRepository.findById(id);
        newFlight.setId(Objects.requireNonNull(flight.block()).getId());
        return flightRepository.save(newFlight);
    }

    @Override
    public void deleteFlight(String id) {
        Mono<Flight> flight = flightRepository.findById(id);
        Flight deletingFlight = new Flight();
        deletingFlight.setId(Objects.requireNonNull(flight.block()).getId());
        flightRepository.delete(deletingFlight);
    }

    @Override
    public void deleteFlightsByDestination(String destination) {
        Flux<Flight> flights = flightRepository.findByDestination(destination);
        flightRepository.deleteAll(flights);
    }
}
