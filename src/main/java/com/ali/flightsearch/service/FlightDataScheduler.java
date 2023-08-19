package com.ali.flightsearch.service;

import com.ali.flightsearch.model.Flight;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightDataScheduler {

    private final FlightDataFetcher flightDataFetcher;
    private final FlightService flightService;

    public FlightDataScheduler(FlightDataFetcher flightDataFetcher, FlightService flightService) {
        this.flightDataFetcher = flightDataFetcher;
        this.flightService = flightService;
    }

    @Scheduled(fixedRate = 3600000)
    public void fetchAndAddFlightData() {
        Flight flightData = flightDataFetcher.fetchFlightData();

        if (flightData != null) {
            flightService.addFlight(flightData);
        }
    }
}

