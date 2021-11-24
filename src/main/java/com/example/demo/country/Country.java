package com.example.demo.country;


import javax.persistence.*;


@Entity
@Table(name = "country")
public class Country {

    @Id
    @SequenceGenerator(
            name = "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_sequence"
    )
    private Long id;
    @Column(name="Name")
    private String name;

}
