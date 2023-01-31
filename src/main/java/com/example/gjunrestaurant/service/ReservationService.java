package com.example.gjunrestaurant.service;

import com.example.gjunrestaurant.dao.ReservationDao;
import com.example.gjunrestaurant.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationDao reservationDao;

    public String createReservation(Reservation reservation) {
        Reservation newReservation = reservationDao.save(reservation);
        return "Reservation[" + newReservation.getID() + "] has be reserved";
    }

    public List<Reservation> getReservations() {
        return Streamable.of(reservationDao.findAll()).toList();
    }

    public Reservation getOneReservation(Integer reservationID) {
        return reservationDao.findById(reservationID).get();
    }

    public String reviseReservation(Reservation reservation) {
        Integer reservationID = reservation.getID();
        reservationDao.save(reservation);
        return "ReservationID[" + reservationID + "] has be updated.";
    }

    public String deleteReservation(Integer reservationID) {
        reservationDao.deleteById(reservationID);
        return "ReservationID[" + reservationID + "] has be deleted";
    }

}
