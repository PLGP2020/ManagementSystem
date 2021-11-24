package com.example.demo.agency;

import com.example.demo.address.Address;
import lombok.*;

import javax.persistence.*;

@Entity(name = "agency")
@Table(name = "agency")
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Agency {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "openHours")
    private String openHours;
    @Column(name = "email")
    private String email;
    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name="addressid",nullable = false)
    private Address address;

    public Agency(String phoneNumber,String openHours, String email) {
         this.phoneNumber = phoneNumber;
         this.openHours = openHours;
         this.email = email;
    }
}
