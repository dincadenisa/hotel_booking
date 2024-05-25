package com.example.hotelbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Clasa care reprezintă un hotel în sistemul de rezervări.
 */
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rating", nullable = false)
    private double rating;

    @Column(name = "rooms_count", nullable = false)
    private int roomsCount;

    @Column(name = "facilities")
    private List<String> facilities;

    /**
     * Constructor implicit pentru obiectul Hotel.
     */
    public Hotel() {
        // Constructor implicit necesar pentru JPA
    }

    /**
     * Constructor pentru obiectul Hotel cu parametri.
     * @param name Numele hotelului.
     * @param address Adresa hotelului.
     * @param description Descrierea hotelului.
     * @param rating Rating-ul hotelului.
     * @param roomsCount Numărul de camere din hotel.
     * @param facilities Lista de facilități ale hotelului.
     */
    public Hotel(String name, String address, String description, double rating, int roomsCount, List<String> facilities) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.rating = rating;
        this.roomsCount = roomsCount;
        this.facilities = facilities;
    }

    // Getters și setters pentru toate câmpurile

    /**
     * Returnează ID-ul hotelului.
     * @return ID-ul hotelului.
     */
    public Long getId() {
        return id;
    }

    // ID Setter
    public void setId(Long id) {
        this.id = id;
    }

    // Name Getter
    public String getName() {
        return name;
    }

    // Name Setter
    public void setName(String name) {
        this.name = name;
    }

    // Address Getter
    public String getAddress() {
        return address;
    }

    // Address Setter
    public void setAddress(String address) {
        this.address = address;
    }

    // Description Getter
    public String getDescription() {
        return description;
    }

    // Description Setter
    public void setDescription(String description) {
        this.description = description;
    }

    // Rating Getter
    public double getRating() {
        return rating;
    }

    // Rating Setter
    public void setRating(double rating) {
        this.rating = rating;
    }

    // RoomsCount Getter
    public int getRoomsCount() {
        return roomsCount;
    }

    // RoomsCount Setter
    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    // Facilities Getter
    public List<String> getFacilities() {
        return facilities;
    }

    // Facilities Setter
    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    /**
     * Returnează o reprezentare sub formă de șir de caractere a obiectului Hotel.
     * @return Șir de caractere care reprezintă obiectul Hotel.
     */
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", roomsCount=" + roomsCount +
                ", facilities=" + facilities +
                '}';
    }
}
