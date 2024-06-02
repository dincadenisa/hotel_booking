package com.example.hotelbackend.model.dao;

import com.example.hotelbackend.model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDAO extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCheckInDateBetween(Date startDate, Date endDate);

    List<Reservation> findByCheckOutDateBetween(Date startDate, Date endDate);

    List<Reservation> findByRoomId(Long roomId);

    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByFirstName(String firstName);

    List<Reservation> findByLastName(String lastName);

    List<Reservation> findByPhoneNumber(String phoneNumber);

    List<Reservation> findByNumberOfPersons(Integer numberOfPersons);

}
