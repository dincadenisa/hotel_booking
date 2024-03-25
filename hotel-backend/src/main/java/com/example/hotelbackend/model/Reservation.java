package com.example.hotelbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 * Clasa care reprezintă o rezervare a unei camere de hotel.
 */
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "check_in_date", nullable = false)
    private Date checkInDate;

    @Column(name = "check_out_date", nullable = false)
    private Date checkOutDate;

    @ManyToOne
    private Room room;

    @ManyToOne
    private User user;

    /**
     * Constructor implicit pentru obiectul Reservation.
     */
    public Reservation() {
        // Constructor implicit necesar pentru JPA
    }

    /**
     * Constructor pentru obiectul Reservation cu parametri.
     * @param checkInDate Data de check-in pentru rezervare.
     * @param checkOutDate Data de check-out pentru rezervare.
     */
    public Reservation(Date checkInDate, Date checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getters și setters pentru toate câmpurile

    /**
     * Returnează ID-ul rezervării.
     * @return ID-ul rezervării.
     */
    public Long getId() {
        return id;
    }

    // Restul metodelor (getters și setters)

    /**
     * Returnează o reprezentare sub formă de șir de caractere a obiectului Reservation.
     * @return Șir de caractere care reprezintă obiectul Reservation.
     */
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", room=" + room +
                ", user=" + user +
                '}';
    }
}
