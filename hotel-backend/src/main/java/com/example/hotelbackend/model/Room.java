package com.example.hotelbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clasa care reprezintă o cameră dintr-un hotel.
 */
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "room_number", nullable = false, unique = true)
    private String roomNumber;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "price_per_night", nullable = false)
    private double pricePerNight;

    @ManyToOne
    private Hotel hotel;

    /**
     * Constructor implicit pentru obiectul Room.
     */
    public Room() {
        // Constructor implicit necesar pentru JPA
    }

    /**
     * Constructor pentru obiectul Room cu parametri.
     * @param roomNumber Numărul camerei.
     * @param type Tipul camerei.
     * @param pricePerNight Prețul pe noapte al camerei.
     */
    public Room(String roomNumber, String type, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    // Getters și setters pentru toate câmpurile

    /**
     * Returnează ID-ul camerei.
     * @return ID-ul camerei.
     */
    public Long getId() {
        return id;
    }

    // Restul metodelor (getters și setters)

    /**
     * Returnează o reprezentare sub formă de șir de caractere a obiectului Room.
     * @return Șir de caractere care reprezintă obiectul Room.
     */
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", type='" + type + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", hotel=" + hotel +
                '}';
    }
}
