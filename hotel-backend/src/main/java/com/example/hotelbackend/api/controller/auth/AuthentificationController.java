package com.example.hotelbackend.api.controller.auth;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlerul pentru autentificare.
 */
@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    private final UserService userService;

    /**
     * Constructor pentru controlerul de autentificare.
     * @param userService Serviciul pentru manipularea utilizatorilor.
     */
    public AuthentificationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint pentru înregistrarea unui utilizator nou.
     * @param registrationBody Informațiile de înregistrare ale utilizatorului.
     * @return Răspunsul HTTP corespunzător.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationBody registrationBody) {
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    /**
     * Endpoint pentru ștergerea unui utilizator.
     * @param registrationBody Informațiile de înregistrare ale utilizatorului.
     */
    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody RegistrationBody registrationBody) {
        this.userService.deleteUser(registrationBody);

    }

    /**
     * Endpoint pentru obținerea informațiilor despre un utilizator.
     *
     * @param registrationBody Informațiile de înregistrare ale utilizatorului.
     * @return
     */
    @GetMapping("/get")
    public User getUser(@RequestBody RegistrationBody registrationBody) {
        return this.userService.getUser(registrationBody);
    }

    /**
     * Endpoint pentru actualizarea informațiilor unui utilizator.
     * @param registrationBody Informațiile de înregistrare ale utilizatorului.
     */
    @PutMapping("/put")
    public void putUser(@RequestBody RegistrationBody registrationBody) {
        this.userService.putUser(registrationBody);
    }
}
