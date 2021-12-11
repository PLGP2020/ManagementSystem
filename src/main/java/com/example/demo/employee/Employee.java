package com.example.demo.employee;

import com.example.demo.agency.Agency;
import com.example.demo.client.Gender;
import com.example.demo.client.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity(name="employee")
@Table(name="employee")
@AttributeOverrides({
        @AttributeOverride(name="Id",column=@Column(name="id")),
        @AttributeOverride(name="firstName",column=@Column(name="firstName")),
        @AttributeOverride(name="lastName",column=@Column(name="lastName")),
        @AttributeOverride(name="email",column=@Column(name="email")),
        @AttributeOverride(name="phoneNumber",column=@Column(name="phoneNumber"))
})
public class Employee extends Person implements Serializable {

    @Column(name="age")
    private int age;
    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name="salary")
    private int salary;
    @Column(name="position")
    private String position;

    @ManyToOne
    @JoinColumn(name="agencyid",referencedColumnName = "id",nullable = false)
    private Agency agency;

    public Employee(String firstName, String lastName, String email,
                    String phoneNumber, int age, Gender gender,int salary,String position,Agency agency) {
        super(firstName, lastName, email, phoneNumber);
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.position = position;
        this.agency = agency;
    }

}
