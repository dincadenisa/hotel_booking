package com.example.hotelbackend.api.controller.auth;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthentificationController {

    private UserService userService;

    public AuthentificationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody RegistrationBody registrationBody){
        userService.registerUser(registrationBody);
    }
}
