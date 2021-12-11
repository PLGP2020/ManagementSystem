package com.example.demo.client;


import com.example.demo.user.SystemUserRole;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="client")
@AttributeOverrides({
        @AttributeOverride(name="id",column=@Column(name="id")),
        @AttributeOverride(name="firstName",column=@Column(name="firstName")),
        @AttributeOverride(name="lastName",column=@Column(name="lastName")),
        @AttributeOverride(name="email",column=@Column(name="email")),
        @AttributeOverride(name="phoneNumber",column=@Column(name="phoneNumber"))
})
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Client extends Person implements Serializable {


    @Column(name="age")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;
    private String imageUrl;


    public Client(String firstName, String lastName, String email,
                  String phoneNumber, String loginName, String password, SystemUserRole appUserRole) {
        super(firstName, lastName, email, phoneNumber);
    }

    public Client(String firstName, String lastName, String email,
                  String phoneNumber, int age, Gender gender,String imageUrl) {
        super(firstName, lastName, email, phoneNumber);
        this.age = age;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }


}

