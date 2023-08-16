package com.ali.flightsearch.service;

import com.ali.flightsearch.model.Flight;
import com.ali.flightsearch.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository repository;

    @Autowired
    public FlightService(FlightRepository repository) {
        this.repository = repository;
    }

    public Flight addFlight(Flight flight) {
        return repository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public Optional<Flight> getFlightById(String id) {
        return repository.findById(id);
    }

    public Flight updateFlight(Flight flight) {
        return repository.save(flight);
    }

    public void deleteFlightById(String id) {
        repository.deleteById(id);
    }
}
