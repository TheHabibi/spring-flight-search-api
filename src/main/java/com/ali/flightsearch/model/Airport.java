package com.ali.flightsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "airports")
public class Airport {

    @Id
    private String id;
    private String city;
}
