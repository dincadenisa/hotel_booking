package com.example.hotelbackend.api.controller.auth;

import com.example.hotelbackend.api.model.HotelRegistrationBody;
import com.example.hotelbackend.exception.HotelAlreadyExistsException;
import com.example.hotelbackend.model.Hotel;
import com.example.hotelbackend.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for hotel management.
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    /**
     * Constructor for the hotel controller.
     * @param hotelService The service for handling hotel operations.
     */
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * Endpoint for registering a new hotel.
     * @param registrationBody The registration information for the hotel.
     * @return The corresponding HTTP response.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerHotel(@RequestBody HotelRegistrationBody registrationBody) {
        try {
            Hotel hotel = hotelService.registerHotel(registrationBody);
            return ResponseEntity.ok(hotel);
        } catch (HotelAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Hotel already exists.");
        }
    }

    /**
     * Endpoint for deleting a hotel.
     * @param id The ID of the hotel to be deleted.
     * @return The corresponding HTTP response.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for retrieving information about a hotel.
     * @param id The ID of the hotel.
     * @return The hotel if found, or a not found response.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getHotel(@PathVariable Long id) {
        return hotelService.getHotelById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint for updating a hotel's information.
     * @param id The ID of the hotel to be updated.
     * @param registrationBody The new registration information for the hotel.
     * @return The updated hotel, or a not found response.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable Long id, @RequestBody HotelRegistrationBody registrationBody) {
        return hotelService.updateHotel(id, registrationBody)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
