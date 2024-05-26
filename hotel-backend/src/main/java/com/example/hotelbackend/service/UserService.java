package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.model.dao.UserDAO;
import com.example.hotelbackend.observer.AdminNotificationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (userDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() ||
                userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        User newUser = new User();
        newUser.setEmail(registrationBody.getEmail());
        newUser.setUsername(registrationBody.getUsername());
        newUser.setFirstName(registrationBody.getFirstName());
        newUser.setLastName(registrationBody.getLastName());
        newUser.setPassword(passwordEncoder.encode(registrationBody.getPassword()));

        return userDAO.save(newUser);
    }

    public User getUser(RegistrationBody registrationBody) {
        return userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).orElse(null);
    }

    public void deleteUser(RegistrationBody registrationBody) {
        userDAO.findByUsernameIgnoreCase(registrationBody.getUsername())
                .ifPresent(userDAO::delete);
    }

    public User putUser(RegistrationBody registrationBody) {
        User existingUser = getUser(registrationBody);
        if (existingUser != null) {
            existingUser.setEmail(registrationBody.getEmail());
            existingUser.setUsername(registrationBody.getUsername());
            existingUser.setFirstName(registrationBody.getFirstName());
            existingUser.setLastName(registrationBody.getLastName());
            existingUser.setPassword(passwordEncoder.encode(registrationBody.getPassword()));
            return userDAO.save(existingUser);
        }
        return null;
    }

    public void attach(AdminNotificationObserver adminNotificationObserver) {
    }
}
