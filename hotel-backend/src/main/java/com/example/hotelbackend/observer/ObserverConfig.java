package com.example.hotelbackend.observer;

import com.example.hotelbackend.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObserverConfig {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminNotificationObserver adminNotificationObserver;

    @PostConstruct
    public void init() {
        userService.attach(adminNotificationObserver);
    }
}
