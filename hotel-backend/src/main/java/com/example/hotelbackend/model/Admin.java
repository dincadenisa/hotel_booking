package com.example.hotelbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clasa care reprezintă un administrator în sistemul hotelier.
 */
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 1000)
    private String password;

    @Column(name = "email", nullable = false, unique = true, length = 320)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "role", nullable = false)
    private String role;

    /**
     * Constructor implicit pentru obiectul Admin.
     */
    public Admin() {
        // Constructor implicit necesar pentru JPA
    }

    /**
     * Constructor pentru obiectul Admin cu parametri.
     * @param username Numele de utilizator al administratorului.
     * @param password Parola administratorului.
     * @param email Adresa de email a administratorului.
     * @param firstName Prenumele administratorului.
     * @param lastName Numele administratorului.
     * @param role Rolul administratorului în sistem.
     */
    public Admin(String username, String password, String email, String firstName, String lastName, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    // Getters și setters pentru toate câmpurile

    /**
     * Returnează ID-ul administratorului.
     * @return ID-ul administratorului.
     */
    public Long getId() {
        return id;
    }

    // Restul metodelor (getters și setters)

    /**
     * Returnează o reprezentare sub formă de șir de caractere a obiectului Admin.
     * @return Șir de caractere care reprezintă obiectul Admin.
     */
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
