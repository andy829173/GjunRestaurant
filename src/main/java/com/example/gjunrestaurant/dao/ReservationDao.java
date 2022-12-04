package com.example.gjunrestaurant.dao;

import com.example.gjunrestaurant.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationDao extends CrudRepository<Reservation, Integer> {

}
