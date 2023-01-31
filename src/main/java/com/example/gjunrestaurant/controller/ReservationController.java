package com.example.gjunrestaurant.controller;

import com.example.gjunrestaurant.entity.Reservation;
import com.example.gjunrestaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping("/reservation")
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }

    @PostMapping("/reservation")
    public String createReservation(Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PatchMapping("/reservation")
    public String reviseReservation(Reservation reservation) {
        return reservationService.reviseReservation(reservation);
    }

    @DeleteMapping("/reservation")
    public String deleteReservation(Integer reservationID) {
        return reservationService.deleteReservation(reservationID);
    }
}
