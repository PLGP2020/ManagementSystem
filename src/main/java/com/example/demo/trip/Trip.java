package com.example.demo.trip;


import javax.persistence.*;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @SequenceGenerator(
            name = "trip_sequence",
            sequenceName = "trip_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trip_sequence"
    )
    private Long id;
    @Column(name = "Price")
    private double price;


}

