package com.ali.flightsearch.controller;

import com.ali.flightsearch.model.Flight;
import com.ali.flightsearch.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight addedFlight = flightService.addFlight(flight);
        return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable String id) {
        return flightService.getFlightById(id)
                .map(flight -> new ResponseEntity<>(flight, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable String id, @RequestBody Flight flight) {
        if (!flightService.getFlightById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        flight.setId(id);
        Flight updatedFlight = flightService.updateFlight(flight);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable String id) {
        if (!flightService.getFlightById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        flightService.deleteFlightById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
