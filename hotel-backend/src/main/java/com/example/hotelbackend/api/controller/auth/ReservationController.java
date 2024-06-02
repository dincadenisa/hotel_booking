package com.example.hotelbackend.api.controller.auth;

import com.example.hotelbackend.api.model.ReservationRegistrationBody;
import com.example.hotelbackend.exception.HotelAlreadyExistsException;
import com.example.hotelbackend.exception.ReservationAlreadyExistsException;
import com.example.hotelbackend.exception.RoomAlreadyExistsException;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.model.Reservation;
import com.example.hotelbackend.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for reservation management.
 */
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    /**
     * Constructor for the reservation controller.
     * @param reservationService The service for handling reservation operations.
     */
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Endpoint for creating a new reservation.
     * @param registrationBody The registration information for the reservation.
     * @return The corresponding HTTP response.
     */
    @PostMapping("/create")
    public ResponseEntity<?> createReservation(@RequestBody ReservationRegistrationBody registrationBody) {
        try {
            Reservation reservation = reservationService.createReservation(registrationBody);
            return ResponseEntity.ok(reservation);
        } catch (HotelAlreadyExistsException | RoomAlreadyExistsException | UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    /**
     * Endpoint for deleting a reservation.
     * @param id The ID of the reservation to be deleted.
     * @return The corresponding HTTP response.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for retrieving information about a reservation.
     * @param id The ID of the reservation.
     * @return The reservation if found, or a not found response.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getReservation(@PathVariable Long id) {
        return reservationService.getReservationById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint for updating a reservation's information.
     * @param id The ID of the reservation to be updated.
     * @param registrationBody The new registration information for the reservation.
     * @return The updated reservation, or a not found response.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody ReservationRegistrationBody registrationBody) {
        try {
            return ResponseEntity.ok(reservationService.updateReservation(id, registrationBody));
        } catch (HotelAlreadyExistsException | RoomAlreadyExistsException | UserAlreadyExistsException |
                 ReservationAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

}
