package com.example.hotelbackend.model.dao;

import com.example.hotelbackend.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminDAO extends JpaRepository<Admin, Long> {
    /**
     * Finds an admin by username, ignoring case.
     *
     * @param username the username to search for
     * @return an optional containing the found admin, or an empty optional if no admin is found
     */
    Optional<Admin> findByUsernameIgnoreCase(String username);

    /**
     * Finds an admin by email, ignoring case.
     *
     * @param email the email to search for
     * @return an optional containing the found admin, or an empty optional if no admin is found
     */
    Optional<Admin> findByEmailIgnoreCase(String email);
}
