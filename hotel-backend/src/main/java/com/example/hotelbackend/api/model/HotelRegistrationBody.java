package com.example.hotelbackend.api.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 * Represents the body of a request to register a new hotel.
 */
public class HotelRegistrationBody {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Rating is required")
    @Min(value = 0, message = "Rating must be a non-negative number")
    private Double rating;

    @NotNull(message = "Rooms count is required")
    @Min(value = 1, message = "Hotel must have at least one room")
    private Integer roomsCount;

    @Size(min = 1, message = "Hotel must have at least one facility")
    private List<String> facilities;

    /**
     * Default constructor for JSON parsing.
     */
    public HotelRegistrationBody() {
    }

    /**
     * Full constructor for creating an instance of HotelRegistrationBody.
     */
    public HotelRegistrationBody(String name, String address, String description, Double rating, Integer roomsCount, List<String> facilities) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.rating = rating;
        this.roomsCount = roomsCount;
        this.facilities = facilities;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(Integer roomsCount) {
        this.roomsCount = roomsCount;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "HotelRegistrationBody{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", roomsCount=" + roomsCount +
                ", facilities=" + facilities +
                '}';
    }
}
