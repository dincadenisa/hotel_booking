package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.model.dao.UserDAO;
import org.springframework.stereotype.Service;

/**
 * Serviciu care gestionează operațiunile legate de utilizatori.
 */
@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Înregistrează un nou utilizator.
     * @param registrationBody Datele de înregistrare ale utilizatorului.
     * @return Utilizatorul înregistrat.
     * @throws UserAlreadyExistsException Excepție aruncată dacă utilizatorul deja există.
     */
    public User registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if (userDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || userDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        User user = new User();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setPassword(registrationBody.getPassword());
        return userDAO.save(user);
    }

    /**
     * Șterge un utilizator.
     * @param registrationBody Datele utilizatorului de șters.
     */
    public void deleteUser(RegistrationBody registrationBody) {
        User user = getUser(registrationBody);
        userDAO.delete(user);
    }

    /**
     * Actualizează datele unui utilizator.
     * @param registrationBody Datele utilizatorului de actualizat.
     * @return Utilizatorul actualizat.
     */
    public User putUser(RegistrationBody registrationBody) {
        User user = getUser(registrationBody);
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setPassword(registrationBody.getPassword());
        return userDAO.save(user);
    }

    /**
     * Obține un utilizator pe baza datelor din corpul cererii.
     * @param registrationBody Datele utilizatorului.
     * @return Utilizatorul.
     */
    public User getUser(RegistrationBody registrationBody) {
        User user = new User();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setPassword(registrationBody.getPassword());
        return user;
    }
}
