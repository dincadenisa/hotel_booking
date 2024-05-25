package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.RegistrationBody;
import com.example.hotelbackend.exception.UserAlreadyExistsException;
import com.example.hotelbackend.model.User;
import com.example.hotelbackend.model.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.never;

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
        when(userDaoMock.save(newUser)).thenReturn(newUser);
        User user= userService.registerUser(registrationBody);
        assertEquals(newUser, user);
        verify(userDaoMock).save(newUser);

    }

    @Test(expected = UserAlreadyExistsException.class)
    public void registerUser_ThrowsException_IfEmailExists() throws UserAlreadyExistsException {
        RegistrationBody registrationBody = new RegistrationBody();
        registrationBody.setEmail("existing@example.com");
        registrationBody.setUsername("newUser");
        registrationBody.setFirstName("First");
        registrationBody.setLastName("Last");
        registrationBody.setPassword("password");

        when(userDaoMock.findByEmailIgnoreCase("existing@example.com")).thenReturn(Optional.of(new User()));

        userService.registerUser(registrationBody);
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void registerUser_ThrowsException_IfUsernameExists() throws UserAlreadyExistsException {
        RegistrationBody registrationBody = new RegistrationBody();
        registrationBody.setEmail("new@example.com");
        registrationBody.setUsername("existingUsername");
        registrationBody.setFirstName("First");
        registrationBody.setLastName("Last");
        registrationBody.setPassword("password");

        when(userDaoMock.findByEmailIgnoreCase("new@example.com")).thenReturn(Optional.empty()); // Ensures email is not found
        when(userDaoMock.findByUsernameIgnoreCase("existingUsername")).thenReturn(Optional.of(new User()));

        userService.registerUser(registrationBody);
    }
    @Test
    public void getUserTest() {
        RegistrationBody registrationBody = new RegistrationBody();
        registrationBody.setUsername("denisa777");

        User existingUser = new User();
        existingUser.setEmail("deni@gmail.com");
        existingUser.setUsername("denisa777");
        existingUser.setFirstName("Denisa");
        existingUser.setLastName("Badea");
        existingUser.setPassword("denideni");

        // Stubbing the userDAO to return the existingUser when findByUsernameIgnoreCase is called with "denisa777"
        when(userDaoMock.findByUsernameIgnoreCase("denisa777")).thenReturn(Optional.of(existingUser));

        // Calling the method to test
        User retrievedUser = userService.getUser(registrationBody);

        // Assertions to check if the retrieved user is the one we expect
        assertEquals(existingUser, retrievedUser, "The retrieved user should match the existing user");

        // Verify that the findByUsernameIgnoreCase method was called with the correct parameter
        verify(userDaoMock).findByUsernameIgnoreCase("denisa777");
    }

    @Test
    public void deleteUserTest() {
        RegistrationBody registrationBody = new RegistrationBody();
        registrationBody.setUsername("denisa777");

        User existingUser = new User();
        existingUser.setEmail("deni@gmail.com");
        existingUser.setUsername("denisa777");
        existingUser.setFirstName("Denisa");
        existingUser.setLastName("Badea");
        existingUser.setPassword("denideni");

        // Stubbing the userDAO to return the existingUser when findByUsernameIgnoreCase is called with "denisa777"
        when(userDaoMock.findByUsernameIgnoreCase("denisa777")).thenReturn(Optional.of(existingUser));

        // Execute the deleteUser method
        userService.deleteUser(registrationBody);

        // Verify that the findByUsernameIgnoreCase method was called with the correct parameter
        verify(userDaoMock).findByUsernameIgnoreCase("denisa777");

        // Verify that delete was called on the userDaoMock with the correct user
        verify(userDaoMock).delete(existingUser);
    }

    @Test
    public void putUserTest() {
        RegistrationBody registrationBody = new RegistrationBody();
        registrationBody.setUsername("denisa777");
        registrationBody.setEmail("update_email@gmail.com");
        registrationBody.setFirstName("UpdatedFirstName");
        registrationBody.setLastName("UpdatedLastName");
        registrationBody.setPassword("updatedPassword");

        User existingUser = new User();
        existingUser.setEmail("deni@gmail.com");
        existingUser.setUsername("denisa777");
        existingUser.setFirstName("Denisa");
        existingUser.setLastName("Badea");
        existingUser.setPassword("denideni");

        User updatedUser = new User();
        updatedUser.setEmail(registrationBody.getEmail());
        updatedUser.setUsername(registrationBody.getUsername());
        updatedUser.setFirstName(registrationBody.getFirstName());
        updatedUser.setLastName(registrationBody.getLastName());
        updatedUser.setPassword(registrationBody.getPassword());

        // Stubbing the userDAO to return the existingUser when findByUsernameIgnoreCase is called with "denisa777"
        when(userDaoMock.findByUsernameIgnoreCase("denisa777")).thenReturn(Optional.of(existingUser));
        // Stubbing the userDAO to return the updatedUser after saving
        when(userDaoMock.save(Mockito.argThat(user -> user.getUsername().equals(registrationBody.getUsername())))).thenReturn(updatedUser);

        // Execute the putUser method
        User resultUser = userService.putUser(registrationBody);

        // Assertions to check if the returned user is the updated one
        assertNotNull(resultUser, "The result should not be null");
        assertEquals(updatedUser.getEmail(), resultUser.getEmail(), "Email should be updated");
        assertEquals(updatedUser.getFirstName(), resultUser.getFirstName(), "First name should be updated");
        assertEquals(updatedUser.getLastName(), resultUser.getLastName(), "Last name should be updated");
        assertEquals(updatedUser.getPassword(), resultUser.getPassword(), "Password should be updated");

        // Capture the user passed to save to verify the exact values
        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userDaoMock).save(userCaptor.capture());
        User capturedUser = userCaptor.getValue();

        assertEquals(registrationBody.getEmail(), capturedUser.getEmail());
        assertEquals(registrationBody.getFirstName(), capturedUser.getFirstName());
        assertEquals(registrationBody.getLastName(), capturedUser.getLastName());
        assertEquals(registrationBody.getPassword(), capturedUser.getPassword());
    }
}



