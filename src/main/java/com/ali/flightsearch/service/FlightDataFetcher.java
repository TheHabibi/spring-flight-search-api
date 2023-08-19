package com.ali.flightsearch.service;

import com.ali.flightsearch.model.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class FlightDataFetcher {

    private final RestTemplate restTemplate;

    public FlightDataFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Flight fetchFlightData() {
        ResponseEntity<Flight> response = restTemplate.getForEntity("https://mock-data-v3g1.onrender.com/api/flight", Flight.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}

