package com.ali.flightsearch.repository;

import com.ali.flightsearch.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<Flight, String> {
}
