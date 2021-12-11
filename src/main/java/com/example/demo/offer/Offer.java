package com.example.demo.offer;


import javax.persistence.*;


@Entity(name="offer")
@Table(name="offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    @Column(name="price")
    private int price;
    @Column(name="description")
    private String description;

}
