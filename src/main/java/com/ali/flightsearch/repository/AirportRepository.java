package com.ali.flightsearch.repository;

import com.ali.flightsearch.model.Airport;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends MongoRepository<Airport, ObjectId> {
}
