package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.model.dao.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService
{
    private UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public User registerUser(RegistrationBody registrationBody){
        User user= new User();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setPassword(registrationBody.getPassword());
        user= userDAO.save(user);
        return user;
    }
}
