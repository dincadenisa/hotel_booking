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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Map<String, String> response = new HashMap<>();
            response.put("role", "USER");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/put")
    public ResponseEntity<?> putUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }
}
