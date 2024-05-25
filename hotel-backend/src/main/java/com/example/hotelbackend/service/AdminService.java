package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.AdminRegistrationBody;
import com.example.hotelbackend.exception.AdminAlreadyExistsException;
import com.example.hotelbackend.model.Admin;
import com.example.hotelbackend.model.dao.AdminDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service managing operations related to admins.
 */
@Service
public class AdminService {

    private final AdminDAO adminDAO;

    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    /**
     * Registers a new admin using the provided registration body.
     * @param registrationBody The registration details for the new admin.
     * @return The registered admin.
     * @throws AdminAlreadyExistsException if the admin already exists.
     */
    public Admin registerAdmin(AdminRegistrationBody registrationBody) throws AdminAlreadyExistsException {
        if (adminDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
                || adminDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
            throw new AdminAlreadyExistsException();
        }
        Admin admin = new Admin();
        admin.setEmail(registrationBody.getEmail());
        admin.setUsername(registrationBody.getUsername());
        admin.setFirstName(registrationBody.getFirstName());
        admin.setLastName(registrationBody.getLastName());
        admin.setPassword(registrationBody.getPassword());
        admin.setRole(registrationBody.getRole());
        return adminDAO.save(admin);
    }

    /**
     * Retrieves an admin based on the registration body details.
     * @param registrationBody The admin details.
     * @return The retrieved admin.
     */
    public Optional<Admin> getAdmin(AdminRegistrationBody registrationBody) {
        return adminDAO.findByUsernameIgnoreCase(registrationBody.getUsername());
    }

    /**
     * Deletes an admin based on the provided registration body.
     * @param registrationBody The admin to delete.
     */
    public void deleteAdmin(AdminRegistrationBody registrationBody) {
        getAdmin(registrationBody).ifPresent(adminDAO::delete);
    }

    /**
     * Updates an admin's details based on the provided registration body.
     * @param registrationBody The details to update.
     * @return The updated admin.
     */
    public Admin updateAdmin(AdminRegistrationBody registrationBody) {
        Optional<Admin> existingAdmin = getAdmin(registrationBody);
        if (existingAdmin.isPresent()) {
            Admin admin = existingAdmin.get();
            admin.setEmail(registrationBody.getEmail());
            admin.setUsername(registrationBody.getUsername());
            admin.setFirstName(registrationBody.getFirstName());
            admin.setLastName(registrationBody.getLastName());
            admin.setPassword(registrationBody.getPassword());
            admin.setRole(registrationBody.getRole());
            return adminDAO.save(admin);
        }
        // Ideally, you might throw an exception or handle the case where the admin doesn't exist.
        return null; // Or consider throwing a custom exception.
    }
}
