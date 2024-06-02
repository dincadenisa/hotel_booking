package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.ReservationRegistrationBody;
import com.example.hotelbackend.exception.HotelAlreadyExistsException;
import com.example.hotelbackend.exception.RoomAlreadyExistsException;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.exception.ReservationAlreadyExistsException;
import com.example.hotelbackend.model.Hotel;
import com.example.hotelbackend.model.Reservation;
import com.example.hotelbackend.model.Room;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.model.dao.ReservationDAO;
import com.example.hotelbackend.api.model.RegistrationBody;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service managing operations related to reservations.
 */
@Service
public class ReservationService {

    private final ReservationDAO reservationDAO;
    private final HotelService hotelService;
    private final RoomService roomService;
    private final UserService userService;

    public ReservationService(ReservationDAO reservationDAO, HotelService hotelService, RoomService roomService, UserService userService) {
        this.reservationDAO = reservationDAO;
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.userService = userService;
    }

    /**
     * Creates a new reservation using the provided registration body.
     *
     * @param reservationBody The details for the new reservation.
     * @return The created reservation.
     * @throws HotelAlreadyExistsException if the hotel does not exist.
     * @throws RoomAlreadyExistsException if the room does not exist.
     * @throws UserAlreadyExistsException if the user does not exist.
     */
    public Reservation createReservation(ReservationRegistrationBody reservationBody) throws HotelAlreadyExistsException, RoomAlreadyExistsException, UserAlreadyExistsException {
        Optional<Hotel> hotel = hotelService.getHotelById(reservationBody.getHotelId());
        if (!hotel.isPresent()) {
            throw new HotelAlreadyExistsException();
        }

        Optional<Room> room = roomService.getRoomById(reservationBody.getRoomId());
        if (!room.isPresent()) {
            throw new RoomAlreadyExistsException();
        }

        // Create a RegistrationBody to fetch the user
        RegistrationBody registrationBody = new RegistrationBody();
        registrationBody.setUsername(reservationBody.getUsername());
        Optional<User> user = Optional.ofNullable(userService.getUser(registrationBody));
        if (!user.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        Reservation reservation = new Reservation();
        reservation.setCheckInDate(reservationBody.getCheckInDate());
        reservation.setCheckOutDate(reservationBody.getCheckOutDate());
        reservation.setRoom(room.get());
        reservation.setUser(user.get());
        reservation.setHotel(hotel.get());
        reservation.setFirstName(reservationBody.getFirstName());
        reservation.setLastName(reservationBody.getLastName());
        reservation.setPhoneNumber(reservationBody.getPhoneNumber());
        reservation.setNumberOfPersons(reservationBody.getNumberOfPersons());

        return reservationDAO.save(reservation);
    }

    /**
     * Deletes a reservation by its ID.
     *
     * @param id The ID of the reservation to delete.
     */
    public void deleteReservation(Long id) {
        reservationDAO.deleteById(id);
    }

    /**
     * Retrieves a reservation by its ID.
     *
     * @param id The ID of the reservation.
     * @return The retrieved reservation, or null if not found.
     */
    public Optional<Reservation> getReservationById(Long id) {
        return reservationDAO.findById(id);
    }

    public Reservation updateReservation(Long id, ReservationRegistrationBody registrationBody) throws ReservationAlreadyExistsException, RoomAlreadyExistsException, HotelAlreadyExistsException, UserAlreadyExistsException {
        Optional<Reservation> existingReservation = reservationDAO.findById(id);
        if (!existingReservation.isPresent()) {
            throw new ReservationAlreadyExistsException();  // You might need to define this exception class if it doesn't exist.
        }

        Optional<Room> existingRoom = roomService.getRoomById(registrationBody.getRoomId());
        if (!existingRoom.isPresent()) {
            throw new RoomAlreadyExistsException();
        }

        Optional<Hotel> existingHotel = hotelService.getHotelById(registrationBody.getHotelId());
        if (!existingHotel.isPresent()) {
            throw new HotelAlreadyExistsException();
        }

        RegistrationBody registrationBodyUser = new RegistrationBody();
        registrationBodyUser.setUsername(registrationBody.getUsername());
        Optional<User> existingUser = Optional.ofNullable(userService.getUser(registrationBodyUser));
        if (!existingUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        Reservation reservation = existingReservation.get();
        reservation.setCheckInDate(registrationBody.getCheckInDate());
        reservation.setCheckOutDate(registrationBody.getCheckOutDate());
        reservation.setRoom(existingRoom.get());
        reservation.setUser(existingUser.get());
        reservation.setHotel(existingHotel.get());
        reservation.setFirstName(registrationBody.getFirstName());
        reservation.setLastName(registrationBody.getLastName());
        reservation.setPhoneNumber(registrationBody.getPhoneNumber());
        reservation.setNumberOfPersons(registrationBody.getNumberOfPersons());

        return reservationDAO.save(reservation);
    }

}
