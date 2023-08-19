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

        String flightDepartureDate = flight.getDepartureDate().substring(0, 10);
        String searchDepartureDate = searchCriteria.getDepartureDate().substring(0, 10);

        boolean departureDateMatches = flightDepartureDate.equals(searchDepartureDate);

        if (searchCriteria.getReturnDate() != null) {
            String flightReturnDate = flight.getReturnDate().substring(0, 10);
            String searchReturnDate = searchCriteria.getReturnDate().substring(0, 10);
            boolean returnDateMatches = flightReturnDate.equals(searchReturnDate);

            return departureAirportMatches && arrivalAirportMatches && departureDateMatches && returnDateMatches;
        } else {
            return departureAirportMatches && arrivalAirportMatches && departureDateMatches;
        }
    }

}
