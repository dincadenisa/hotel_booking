package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.RoomRegistrationBody;
import com.example.hotelbackend.exception.HotelAlreadyExistsException;
import com.example.hotelbackend.exception.RoomAlreadyExistsException;
import com.example.hotelbackend.model.Hotel;
import com.example.hotelbackend.model.Room;
import com.example.hotelbackend.model.dao.RoomDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service managing operations related to rooms.
 */
@Service
public class RoomService {

    private final RoomDAO roomDAO;

    private final HotelService hotelService;

    public RoomService(RoomDAO roomDAO, HotelService hotelService) {
        this.roomDAO = roomDAO;
        this.hotelService = hotelService;
    }

    /**
     * Registers a new room using the provided registration body.
     * @param registrationBody The registration details for the new room.
     * @return The registered room.
     * @throws HotelAlreadyExistsException if the hotel does not exist.
     */
    public Room registerRoom(RoomRegistrationBody registrationBody) throws HotelAlreadyExistsException {
        Optional<Hotel> existingHotel = hotelService.getHotelById(registrationBody.getHotelId());
        if (!existingHotel.isPresent()) {
            throw new HotelAlreadyExistsException();
        }
        Room room = new Room();
        room.setRoomNumber(registrationBody.getRoomNumber());
        room.setType(registrationBody.getType());
        room.setPricePerNight(registrationBody.getPricePerNight());
        room.setHotel(existingHotel.get());
        return roomDAO.save(room);
    }

    /**
     * Deletes a room by its ID.
     * @param id The ID of the room to delete.
     */
    public void deleteRoom(Long id) {
        roomDAO.deleteById(id);
    }

    /**
     * Retrieves a room by its ID.
     * @param id The ID of the room.
     * @return The retrieved room.
     */
    public Optional<Room> getRoomById(Long id) {
        return roomDAO.findById(id);
    }

    /**
     * Updates a room's details based on the provided registration body and ID.
     * @param id The ID of the room to update.
     * @param registrationBody The details to update.
     * @return The updated room.
     * @throws RoomAlreadyExistsException if the room does not exist.
     * @throws HotelAlreadyExistsException if the hotel does not exist.
     */
    public Room updateRoom(Long id, RoomRegistrationBody registrationBody) throws RoomAlreadyExistsException, HotelAlreadyExistsException {
        Optional<Room> existingRoom = roomDAO.findById(id);
        if (!existingRoom.isPresent()) {
            throw new RoomAlreadyExistsException();
        }
        Optional<Hotel> existingHotel = hotelService.getHotelById(registrationBody.getHotelId());
        if (!existingHotel.isPresent()) {
            throw new HotelAlreadyExistsException();
        }
        Room room = existingRoom.get();
        room.setRoomNumber(registrationBody.getRoomNumber());
        room.setType(registrationBody.getType());
        room.setPricePerNight(registrationBody.getPricePerNight());
        room.setHotel(existingHotel.get());
        return roomDAO.save(room);
    }
}
