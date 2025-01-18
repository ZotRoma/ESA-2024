package com.example.labjms.model;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "email")
    private String email;

}