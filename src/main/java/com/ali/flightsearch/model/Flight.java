package com.ali.flightsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "flights")
public class Flight {

    @Id
    private String id;
    private String departureAirport;
    private String arrivalAirport;
    private String departureDate;
    private String returnDate;
    private Double price;
}