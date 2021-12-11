package com.example.demo.contract;

import javax.persistence.*;
import java.util.Date;

@Entity(name="contract")
@Table(name="contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    @Column
    private Date dateOfOrder;
    @Column
    private Date dateOfPayment;
    @Column
    private double amount;

}
