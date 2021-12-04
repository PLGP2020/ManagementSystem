package com.example.demo.employee;

import com.example.demo.agency.Agency;
import com.example.demo.client.Gender;
import com.example.demo.client.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name="employee")
@AttributeOverrides({
        @AttributeOverride(name="Id",column=@Column(name="Id")),
        @AttributeOverride(name="firstName",column=@Column(name="firstName")),
        @AttributeOverride(name="lastName",column=@Column(name="lastName")),
        @AttributeOverride(name="email",column=@Column(name="email")),
        @AttributeOverride(name="phoneNumber",column=@Column(name="phoneNumber"))
})
public class Employee extends Person implements Serializable {

    @Column(name="age")
    private int age;
    @Column(name="gender")
    private Gender gender;
    @Column(name="loginName")
    private String loginName;
    @Column(name="password")
    private String password;

    @ManyToOne()
    @JoinColumn(name="agencyid",referencedColumnName = "id",nullable = false)
    private Agency agency;

    public Employee(String firstName, String lastName, String email,
                    String phoneNumber, int age, Gender gender) {
        super(firstName, lastName, email, phoneNumber);
        this.age = age;
        this.gender = gender;
    }

}
