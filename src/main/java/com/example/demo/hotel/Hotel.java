package com.example.demo.hotel;


import javax.persistence.*;

@Entity(name="hotel")
@Table(name="hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
}
