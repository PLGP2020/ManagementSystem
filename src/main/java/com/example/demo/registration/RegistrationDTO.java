package com.example.demo.registration;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationDTO implements Serializable {

      private  String name;
      private  String username;
      private  String password;
      private  String email;



}
