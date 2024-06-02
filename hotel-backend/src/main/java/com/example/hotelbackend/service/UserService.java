package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.model.dao.UserDAO;
import com.example.hotelbackend.observer.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final BCryptPasswordEncoder passwordEncoder;
    private final List<Observer> observers = new ArrayList<>();

    @Autowired
    public UserService(UserDAO userDAO, BCryptPasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(User user) {
        for (Observer observer : observers) {
            observer.update(user);
        }
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

        User savedUser = userDAO.save(newUser);
        notifyObservers(savedUser);
        return savedUser;
    }

    public User getUser(RegistrationBody registrationBody) {
        return userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).orElse(null);
    }

    public void deleteUserById(Long id) {
        userDAO.deleteById(id);
    }

    public User updateUser(User user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userDAO.save(user);
    }

    public List<User> findAllUsers() {
        return userDAO.findAll();
    }
}
