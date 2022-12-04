package com.example.gjunrestaurant.service;

import com.example.gjunrestaurant.dao.ReservationDao;
import com.example.gjunrestaurant.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationDao reservationDao;

    public Reservation createReservation(Reservation reservation) {
        return reservationDao.save(reservation);
    }

    public Iterable<Reservation> readAll() {
        return reservationDao.findAll();
    }

    public Reservation updateReservation(Reservation reservation) {
        Integer reservationID = reservation.getID();
        Reservation dbReservation = reservationDao.findById(reservationID).get();

        dbReservation.setDate(reservation.getDate());
        dbReservation.setTime(reservation.getTime());
        dbReservation.setTableFor(reservation.getTableFor());
        dbReservation.setName(reservation.getName());
        dbReservation.setPhone(reservation.getPhone());
        dbReservation.setEmail(reservation.getEmail());
        
        return reservationDao.save(dbReservation);
    }
}
