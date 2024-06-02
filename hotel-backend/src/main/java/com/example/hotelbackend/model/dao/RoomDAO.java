package com.example.hotelbackend.model.dao;

import com.example.hotelbackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomDAO extends JpaRepository<Room,Long> {
    /**
     * Finds a room by its room number, ignoring case.
     * @param roomNumber The room number to search for.
     * @return An Optional containing the found room if it exists, or an empty Optional otherwise.
     */
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
