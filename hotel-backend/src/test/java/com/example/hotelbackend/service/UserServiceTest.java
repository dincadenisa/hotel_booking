package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.model.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    @Mock
    private UserDAO userDaoMock;
    private UserService userService;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        userService= new UserService(userDaoMock);
    }

    @Test
    public void saveUserTest() throws UserAlreadyExistsException {
        RegistrationBody registrationBody= new RegistrationBody();
        registrationBody.setEmail("deni@gmail.com");
        registrationBody.setUsername("denisa777");
        registrationBody.setFirstName("Denisa");
        registrationBody.setLastName("Badea");
        registrationBody.setPassword("denideni");

        User newUser = new User();
        newUser.setEmail(registrationBody.getEmail());
        newUser.setUsername(registrationBody.getUsername());
        newUser.setFirstName(registrationBody.getFirstName());
        newUser.setLastName(registrationBody.getLastName());
        newUser.setPassword(registrationBody.getPassword());
        Mockito.when(userDaoMock.save(newUser)).thenReturn(newUser);
        User user= userService.registerUser(registrationBody);
        assertEquals(newUser, user);
        Mockito.verify(userDaoMock).save(newUser);

    }
}
