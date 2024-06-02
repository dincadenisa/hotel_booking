package com.example.hotelbackend.api.controller.auth;

import com.example.hotelbackend.api.model.AdminRegistrationBody;
import com.example.hotelbackend.exception.AdminAlreadyExistsException;
import com.example.hotelbackend.model.Admin;
import com.example.hotelbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Controller for admin authentication and management.
 */
@RestController
@RequestMapping("/admin/auth")
public class AdminAuthentificationController {

    private final AdminService adminService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AdminAuthentificationController(AdminService adminService, BCryptPasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.passwordEncoder = passwordEncoder;
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
     * Endpoint for admin login.
     * @param loginBody The login information for the admin.
     * @return The corresponding HTTP response.
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminRegistrationBody loginBody) {
        Admin admin = adminService.getAdmin(loginBody).orElse(null);
        if (admin != null && passwordEncoder.matches(loginBody.getPassword(), admin.getPassword())) {
            Map<String, String> response = new HashMap<>();
            response.put("role", "ADMIN");
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }

    /**
     * Endpoint for deleting an admin.
     * @param registrationBody The registration information of the admin to be deleted.
     * @return The corresponding HTTP response.
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
