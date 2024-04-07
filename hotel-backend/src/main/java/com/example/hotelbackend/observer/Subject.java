package com.example.hotelbackend.observer;

import com.example.hotelbackend.model.User;

/**
 * Represents a subject in the Observer design pattern.
 * This interface defines the operations for attaching, detaching, and notifying observers.
 * Implementations of this interface will maintain a list of observers and notify them of
 * changes or events, typically by calling their {@link Observer#update(User)} method.
 */
public interface Subject {

    /**
     * Attaches an observer to the subject.
     * This method registers an observer to be notified of events. Observers attached through this
     * method will receive updates when the {@link #notifyObservers(User)} method is called.
     * @param observer The observer to attach.
     */
    void attach(Observer observer);

    /**
     * Detaches an observer from the subject.
     * This method unregisters an observer from the notification list. Observers detached through
     * this method will no longer receive updates when the subject's state changes.
     * @param observer The observer to detach.
     */
    void detach(Observer observer);

    /**
     * Notifies all attached observers of an event.
     * This method is called to notify all observers registered with the subject of an event or
     * a change in the subject's state. The specific user instance associated with the event
     * is passed to the observers.
     * @param user The user instance associated with the event that observers are being notified of.
     */
    void notifyObservers(User user);
}
