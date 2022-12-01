package com.example.gjunrestaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reservation {
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
