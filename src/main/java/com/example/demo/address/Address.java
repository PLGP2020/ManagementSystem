package com.example.demo.address;

import com.example.demo.agency.Agency;
import lombok.*;

import javax.persistence.*;

@Entity(name = "address")
@Table(name = "address")
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressid",nullable = false)
    private Long id;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "street")
    private String street;
    @Column(name = "streetNumber")
    private int streetNumber;
    @OneToOne(mappedBy = "address",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Agency agency;


    public Address(String postalCode,String street,int streetNumber) {
        this.postalCode = postalCode;
        this.street = street;
        this.streetNumber = streetNumber;
    }


}
