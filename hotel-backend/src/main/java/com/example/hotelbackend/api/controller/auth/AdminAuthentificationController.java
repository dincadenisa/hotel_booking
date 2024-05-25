package com.example.hotelbackend.api.controller.auth;

import com.example.hotelbackend.api.model.AdminRegistrationBody;
import com.example.hotelbackend.exception.AdminAlreadyExistsException;
import com.example.hotelbackend.model.Admin;
import com.example.hotelbackend.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for admin authentication and management.
 */
@RestController
@RequestMapping("/admin/auth")
public class AdminAuthentificationController {

    private final AdminService adminService;

    /**
     * Constructor for the admin authentication controller.
     * @param adminService The service for handling admin operations.
     */
    public AdminAuthentificationController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * Endpoint for registering a new admin.
     * @param registrationBody The registration information for the admin.
     * @return The corresponding HTTP response.
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminRegistrationBody registrationBody) {
        try {
            Admin admin = adminService.registerAdmin(registrationBody);
            return ResponseEntity.ok(admin);
        } catch (AdminAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Admin already exists.");
        }
    }

    /**
     * Endpoint for deleting an admin.
     * @param registrationBody The registration information of the admin to be deleted.
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAdmin(@RequestBody AdminRegistrationBody registrationBody) {
        adminService.deleteAdmin(registrationBody);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for retrieving information about an admin.
     * @param registrationBody The registration information of the admin.
     * @return The admin if found, or a not found response.
     */
    @GetMapping("/get")
    public ResponseEntity<?> getAdmin(@RequestBody AdminRegistrationBody registrationBody) {
        return adminService.getAdmin(registrationBody)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint for updating an admin's information.
     * @param registrationBody The registration information of the admin to be updated.
     * @return The updated admin, or a not found response.
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateAdmin(@RequestBody AdminRegistrationBody registrationBody) {
        Admin updatedAdmin = adminService.updateAdmin(registrationBody);
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
