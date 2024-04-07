package com.example.hotelbackend.observer;

import com.example.hotelbackend.model.User;

public interface Observer {
    void update(User user);
}