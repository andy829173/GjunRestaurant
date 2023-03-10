package com.example.gjunrestaurant.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@Data
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;

    @Column(name = "date")
    String date;

    @Column(name = "time")
    String time;

    @Column(name = "tableFor")
    Integer tableFor;

    @Column(name = "name")
    String name;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;
}
