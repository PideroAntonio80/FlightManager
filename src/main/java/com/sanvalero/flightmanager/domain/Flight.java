package com.sanvalero.flightmanager.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * Creado por @ author: Pedro Orós
 * el 15/03/2021
 */

@Data
@NoArgsConstructor
@Document(value = "flights")
public class Flight {

    @Id
    private String id;
    @Field
    private String origin;
    @Field
    private String destination;
    @Field
    private float price;
    @Field
    private int scales;
    @Field
    private String company;
    @Field(name= "creation_date")
    private LocalDateTime creationDate;
}
