package com.example.hotelbackend.observer;

import com.example.hotelbackend.model.User;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(User user);
}