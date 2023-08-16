package com.ali.flightsearch.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "airports")
@Data
@Getter
@Setter
public class Airport {
    @Id
    private ObjectId id; // Use ObjectId or a compatible type
    private String city;
}


