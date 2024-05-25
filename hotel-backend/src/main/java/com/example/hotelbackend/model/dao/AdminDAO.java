package com.example.hotelbackend.model.dao;

import com.example.hotelbackend.model.Admin;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface AdminDAO extends CrudRepository<Admin, Long> {
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
