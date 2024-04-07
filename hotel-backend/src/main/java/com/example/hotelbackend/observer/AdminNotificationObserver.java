package com.example.hotelbackend.observer;

import com.example.hotelbackend.model.User;
import com.example.hotelbackend.observer.Observer;
import org.springframework.stereotype.Component;

@Component
public class AdminNotificationObserver implements Observer {
    @Override
    public void update(User user) {
        // Logic to notify admins about the new user registration
        System.out.println("Admin notified about new user: " + user.getUsername());
        // Additional implementation
    }
}
