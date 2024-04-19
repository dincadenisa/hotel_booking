package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.model.dao.UserDAO;
import com.example.hotelbackend.observer.Observer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service managing user-related operations and implementing the Subject part of the Observer pattern.
 */
@Service
public class UserService {

    private final UserDAO userDAO;
    private final List<Observer> observers = new ArrayList<>();

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Attach an observer to this subject.
     * @param observer The observer to attach.
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Detach an observer from this subject.
     * @param observer The observer to detach.
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notify all attached observers about the event.
     * @param user The user that triggers the notification.
     */
    private void notifyObservers(User user) {
        for (Observer observer : observers) {
            observer.update(user);
        }
    }

    /**
     * Registers a new user and notifies observers.
     * @param registrationBody The registration details of the user.
     * @return The registered user.
     * @throws UserAlreadyExistsException If the user already exists.
     */
    public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
//        if (userDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() ||
//                userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
//            throw new UserAlreadyExistsException();
//        }

        User newUser = new User();
        newUser.setEmail(registrationBody.getEmail());
        newUser.setUsername(registrationBody.getUsername());
        newUser.setFirstName(registrationBody.getFirstName());
        newUser.setLastName(registrationBody.getLastName());
        newUser.setPassword(registrationBody.getPassword());

        User savedUser = userDAO.save(newUser);

        // Notify all observers about the new user registration
        notifyObservers(savedUser);

        return savedUser;
    }

    /**
     * Retrieves a user based on the provided details.
     * @param registrationBody The details to search for.
     * @return The found user or null if not found.
     */
    public User getUser(RegistrationBody registrationBody) {
        return userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).orElse(null);
    }

    /**
     * Deletes a user based on the provided details.
     * @param registrationBody The details to identify the user to delete.
     */
    public void deleteUser(RegistrationBody registrationBody) {
        userDAO.findByUsernameIgnoreCase(registrationBody.getUsername())
                .ifPresent(userDAO::delete);
    }

    /**
     * Updates a user based on the provided details.
     * @param registrationBody The new details for the user.
     * @return The updated user, or null if the user was not found.
     */
    public User putUser(RegistrationBody registrationBody) {
        User user = getUser(registrationBody);
        if (user != null) {
            user.setEmail(registrationBody.getEmail());
            user.setUsername(registrationBody.getUsername());
            user.setFirstName(registrationBody.getFirstName());
            user.setLastName(registrationBody.getLastName());
            user.setPassword(registrationBody.getPassword());

            user = userDAO.save(user);
            System.out.println("Updated user: " + user.getEmail());
        }
        return user;
    }
}
