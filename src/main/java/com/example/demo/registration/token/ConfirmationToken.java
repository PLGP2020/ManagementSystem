/*package com.example.demo.registration.token;

import com.example.demo.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken {
     @Id
     @SequenceGenerator(
             name = "conformation_sequence",
             sequenceName = "confirmation_sequence",
             allocationSize = 1
     )
     @GeneratedValue(
             strategy = GenerationType.SEQUENCE,
             generator ="confirmation_sequence"
     )
   private Long id;
   @Column(name="token",nullable = false)
   private String token;
   @Column(name="createdAt",nullable = false)
   private LocalDateTime createdAt;
   @Column(name="expiredAt",nullable = false)
   private LocalDateTime expiredAt;
   @Column(name="confirmedAt",nullable = false)
   private LocalDateTime confirmedAt;

   @ManyToOne
   @JoinColumn(
           nullable = false,
           name = "client_id"
   )
   private Client client;

   public ConfirmationToken(String token,
                              LocalDateTime createdAt,
                              LocalDateTime expiredAt,
                              LocalDateTime confirmedAt,
                            Client client) {
          this.token = token;
          this.createdAt = createdAt;
          this.expiredAt = expiredAt;
          this.confirmedAt = confirmedAt;
          this.client = client;
     }
} */
