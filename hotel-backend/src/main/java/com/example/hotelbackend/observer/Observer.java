package com.example.hotelbackend.observer;

import com.example.hotelbackend.model.User;

/**
 * Represents an observer in the observer pattern.
 * Observers implementing this interface can receive updates about
 * changes in the subject they are observing. This interface is a part
 * of the observer pattern implementation, allowing for loose coupling
 * between the subject and its observers.
 */
public interface Observer {

    /**
     * Updates the observer with information about a change in the subject.
     * This method is called when the subject to which the observer is attached
     * triggers an update. Implementations of this method can perform actions
     * such as sending notifications based on the change.
     * @param user The user instance that signifies a change or event
     *             that the observer needs to react to.
     */
    void update(User user);
}
