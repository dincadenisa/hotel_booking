package com.example.hotelbackend.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Represents the body of a request to register a new room.
 */
public class RoomRegistrationBody {

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    @NotBlank(message = "Type is required")
    private String type;

    @NotNull(message = "Price per night is required")
    private Double pricePerNight;

    @NotNull(message = "Hotel ID is required")
    private Long hotelId;

    /**
     * Default constructor for JSON parsing.
     */
    public RoomRegistrationBody() {
    }

    /**
     * Full constructor for creating an instance of RoomRegistrationBody.
     */
    public RoomRegistrationBody(String roomNumber, String type, Double pricePerNight, Long hotelId) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.hotelId = hotelId;
    }

    // Getters and setters

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "RoomRegistrationBody{" +
                "roomNumber='" + roomNumber + '\'' +
                ", type='" + type + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", hotelId=" + hotelId +
                '}';
    }
}
