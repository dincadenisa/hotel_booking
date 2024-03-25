package com.example.hotelbackend.api.model;

import jakarta.validation.constraints.Email;

/**
 * Clasa de model care reprezintă datele de înregistrare trimise în corpul cererii.
 */
public class RegistrationBody {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    /**
     * Obține numele de utilizator.
     * @return Numele de utilizator.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setează numele de utilizator.
     * @param username Numele de utilizator.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obține adresa de email.
     * @return Adresa de email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setează adresa de email.
     * @param email Adresa de email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obține parola.
     * @return Parola.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setează parola.
     * @param password Parola.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obține prenumele.
     * @return Prenumele.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setează prenumele.
     * @param firstName Prenumele.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Obține numele de familie.
     * @return Numele de familie.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setează numele de familie.
     * @param lastName Numele de familie.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
