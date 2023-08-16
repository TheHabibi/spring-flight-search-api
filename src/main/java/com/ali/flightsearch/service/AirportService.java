package com.ali.flightsearch.service;

import com.ali.flightsearch.model.Airport;
import com.ali.flightsearch.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository repository;

    @Autowired
    public AirportService(AirportRepository repository) {
        this.repository = repository;
    }

    public Airport addAirport(Airport airport) {
        return repository.save(airport);
    }

    public List<Airport> getAllAirports() {
        return repository.findAll();
    }

    public Optional<Airport> getAirportById(String id) {
        return repository.findById(id);
    }

    public Airport updateAirport(Airport airport) {
        return repository.save(airport);
    }

    public void deleteAirportById(String id) {
        repository.deleteById(id);
    }
}
