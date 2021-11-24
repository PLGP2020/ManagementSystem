package com.example.demo.employee;

import com.example.demo.client.AppUserRole;
import com.example.demo.client.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
public class Employee extends Person {

    @Column(name="age")
    private int age;
    @Column(name="gender")
    private String gender;
    @Column(name="loginName")
    private String loginName;
    @Column(name="password")
    private String password;
    @Enumerated (EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabled;

    public Employee(String firstName, String lastName, String email,
                    String phoneNumber, int age, String gender,
                    String loginName, String password, AppUserRole appUserRole,
                    Boolean locked, Boolean enabled) {
        super(firstName, lastName, email, phoneNumber);
        this.age = age;
        this.gender = gender;
        this.loginName = loginName;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }




}
