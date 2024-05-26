package com.example.hotelbackend.api.controller.auth;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthentificationController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationBody registrationBody) {
        try {
            User registeredUser = userService.registerUser(registrationBody);
            return ResponseEntity.ok(registeredUser);
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody RegistrationBody loginBody) {
        User user = userService.getUser(loginBody);
        if (user != null && passwordEncoder.matches(loginBody.getPassword(), user.getPassword())) {
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestBody RegistrationBody registrationBody) {
        User user = userService.getUser(registrationBody);
        if (user != null) {
            userService.deleteUser(registrationBody);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUser(@RequestBody RegistrationBody registrationBody) {
        User user = userService.getUser(registrationBody);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/put")
    public ResponseEntity<?> putUser(@RequestBody RegistrationBody registrationBody) {
        User updatedUser = userService.putUser(registrationBody);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
