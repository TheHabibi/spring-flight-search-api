package com.ali.flightsearch.service;

import com.ali.flightsearch.model.Flight;
import com.ali.flightsearch.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Flight> searchFlights(Flight searchCriteria) {
        List<Flight> allFlights = repository.findAll();
        
        List<Flight> matchingFlights = allFlights.stream()
                .filter(flight -> matchesCriteria(flight, searchCriteria))
                .collect(Collectors.toList());

        return matchingFlights;
    }

    private boolean matchesCriteria(Flight flight, Flight searchCriteria) {

        boolean departureAirportMatches = flight.getDepartureAirport().equalsIgnoreCase(searchCriteria.getDepartureAirport());
        boolean arrivalAirportMatches = flight.getArrivalAirport().equalsIgnoreCase(searchCriteria.getArrivalAirport());

        String flightDepartureDate = flight.getDepartureTime().substring(0, 10);
        String flightArrivalDate = flight.getArrivalTime().substring(0, 10);
        String searchDepartureDate = searchCriteria.getDepartureTime().substring(0, 10);
        String searchArrivalDate = searchCriteria.getArrivalTime().substring(0, 10);

        boolean departureDateMatches = flightDepartureDate.equals(searchDepartureDate);
        boolean arrivalDateMatches = flightArrivalDate.equals(searchArrivalDate);

        if (searchCriteria.getArrivalTime() != null) {
            return departureAirportMatches && arrivalAirportMatches && departureDateMatches && arrivalDateMatches;
        } else {
            return departureAirportMatches && arrivalAirportMatches && departureDateMatches;
        }
    }

}
