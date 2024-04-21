package com.example.hotelbackend.model.dao;

import com.example.hotelbackend.model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationDAO extends CrudRepository<Reservation, Long> {
    List<Reservation> findByCheckInDateBetween(Date startDate, Date endDate);

    List<Reservation> findByCheckOutDateBetween(Date startDate, Date endDate);

    List<Reservation> findByRoomId(Long roomId);

    List<Reservation> findByUserId(Long userId);
}
