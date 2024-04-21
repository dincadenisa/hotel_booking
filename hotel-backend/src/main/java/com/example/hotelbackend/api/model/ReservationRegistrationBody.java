package com.example.hotelbackend.api.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

/**
 * Class representing the reservation data sent in the request body.
 */
public class ReservationRegistrationBody {
    @NotNull
    private Long hotelId;

    @NotNull
    private Long roomId;

    @NotNull
    private String username;

    @NotEmpty
    private String roomNumber;

    @NotNull
    private Date checkInDate;

    @NotNull
    private Date checkOutDate;

    @NotEmpty
    private String guestName;

    /**
     * Gets the hotel ID.
     * @return The hotel ID.
     */
    public Long getHotelId() {
        return hotelId;
    }

    /**
     * Sets the hotel ID.
     * @param hotelId The hotel ID to set.
     */
    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public Long getRoomId() {
        return roomId;
    }

    /**
     * Sets the hotel ID.
     * @param roomId The hotel ID to set.
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    /**
     * Gets the room number.
     * @return The room number.
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the room number.
     * @param roomNumber The room number to set.
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Gets the check-in date.
     * @return The check-in date.
     */
    public Date getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets the check-in date.
     * @param checkInDate The check-in date to set.
     */
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * Gets the check-out date.
     * @return The check-out date.
     */
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the check-out date.
     * @param checkOutDate The check-out date to set.
     */
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * Gets the guest name.
     * @return The guest name.
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Sets the guest name.
     * @param guestName The guest name to set.
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
}
