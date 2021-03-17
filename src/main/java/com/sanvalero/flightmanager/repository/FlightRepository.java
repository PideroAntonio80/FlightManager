package com.sanvalero.flightmanager.repository;

import com.sanvalero.flightmanager.domain.Flight;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Creado por @ author: Pedro Orós
 * el 15/03/2021
 */

@Repository
public interface FlightRepository extends ReactiveMongoRepository<Flight, Long> {

    Flux<Flight> findAll();
    Mono<Flight> findById(String id);
    Flux<Flight> findByOrigin(String origin);
    Flux<Flight> findByDestination(String destination);
    Flux<Flight> findByScales(int scales);
}
