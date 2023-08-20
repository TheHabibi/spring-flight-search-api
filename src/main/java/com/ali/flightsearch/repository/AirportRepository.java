package com.ali.flightsearch.repository;

import com.ali.flightsearch.model.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirportRepository extends MongoRepository<Airport, String> {
}
