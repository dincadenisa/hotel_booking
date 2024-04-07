package com.example.hotelbackend.observer;

import com.example.hotelbackend.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Initializes and configures observers for the application.
 * This class is responsible for setting up the observer pattern
 * configuration, specifically attaching the {@link AdminNotificationObserver}
 * to the {@link UserService} to enable notification functionalities
 * upon user registration events.
 */
@Component
public class ObserverConfig {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminNotificationObserver adminNotificationObserver;

    /**
     * Attaches the {@link AdminNotificationObserver} to the {@link UserService}.
     * This method is automatically invoked after the bean's properties have been
     * autowired by Spring's dependency injection facilities. It attaches the
     * admin notification observer to the user service to ensure that
     * administrative notifications are triggered upon specific events,
     * such as user registration.
     */
    @PostConstruct
    public void init() {
        userService.attach(adminNotificationObserver);
    }
}
