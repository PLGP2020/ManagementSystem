package com.example.demo.client;

import lombok.*;

import javax.persistence.*;


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
public class Client extends Person {


    @Column(name="age")
    private int age;
    @Column(name="gender")
    private String gender;
    @Column(name="loginName")
    private String loginName;
    @Column(name="password")
    private String password;

    public Client(String firstName, String lastName, String email,
                  String phoneNumber, String loginName,String password,AppUserRole appUserRole) {
        super(firstName, lastName, email, phoneNumber);
        this.loginName = loginName;
        this.password = password;
    }

    public Client(String firstName, String lastName, String email,
                  String phoneNumber, int age, String gender) {
        super(firstName, lastName, email, phoneNumber);
        this.age = age;
        this.gender = gender;
    }


}

