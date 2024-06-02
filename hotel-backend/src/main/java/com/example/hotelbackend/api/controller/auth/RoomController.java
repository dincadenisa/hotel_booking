package com.example.hotelbackend.api.controller.auth;

import com.example.hotelbackend.api.model.RoomRegistrationBody;
import com.example.hotelbackend.exception.HotelAlreadyExistsException;
import com.example.hotelbackend.exception.RoomAlreadyExistsException;
import com.example.hotelbackend.model.Room;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.List;

/**
 * Controller for room management.
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    /**
     * Constructor for the room controller.
     * @param roomService The service for handling room operations.
     */
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * Endpoint for registering a new room.
     * @param registrationBody The registration information for the room.
     * @return The corresponding HTTP response.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerRoom(@RequestBody RoomRegistrationBody registrationBody) {
        try {
            Room room = roomService.registerRoom(registrationBody);
            return ResponseEntity.ok(room);
        } catch (HotelAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel not found.");
        }
    }

    /**
     * Endpoint for deleting a room.
     * @param id The ID of the room to be deleted.
     * @return The corresponding HTTP response.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for retrieving information about a room.
     * @param id The ID of the room.
     * @return The room if found, or a not found response.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getRoom(@PathVariable Long id) {
        return roomService.getRoomById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/allrooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room>  rooms= roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }



    /**
     * Endpoint for updating a room's information.
     * @param id The ID of the room to be updated.
     * @param registrationBody The new registration information for the room.
     * @return The updated room, or a not found response.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Long id, @RequestBody RoomRegistrationBody registrationBody) {
        try {
            return ResponseEntity.ok(roomService.updateRoom(id, registrationBody));
        } catch (RoomAlreadyExistsException | HotelAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found.");
        }
    }
}
