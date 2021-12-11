package com.example.demo.city;

import lombok.*;

import javax.persistence.*;

@Entity(name="city")
@Table(name="city")
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name="name")
    private String name;


    public City(String name) {
          this.name = name;
    }


}
