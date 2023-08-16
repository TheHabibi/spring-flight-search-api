package com.ali.flightsearch.controller;

import com.ali.flightsearch.model.Airport;
import com.ali.flightsearch.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        Airport addedAirport = airportService.addAirport(airport);
        return new ResponseEntity<>(addedAirport, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportService.getAllAirports();
        return new ResponseEntity<>(airports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable String id) {
        return airportService.getAirportById(id)
                .map(airport -> new ResponseEntity<>(airport, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable String id, @RequestBody Airport airport) {
        if (!airportService.getAirportById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        airport.setId(id);
        Airport updatedAirport = airportService.updateAirport(airport);
        return new ResponseEntity<>(updatedAirport, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable String id) {
        if (!airportService.getAirportById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        airportService.deleteAirportById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
