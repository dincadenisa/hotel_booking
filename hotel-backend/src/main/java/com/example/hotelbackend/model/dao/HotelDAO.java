package com.example.hotelbackend.model.dao;

import com.example.hotelbackend.model.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HotelDAO extends CrudRepository<Hotel, Long> {
    /**
     * Finds hotels by name, ignoring case.
     *
     * @param name the name to search for
     * @return a list of hotels matching the name, case-insensitive
     */
    Optional<Hotel> findByNameIgnoreCase(@Param("name") String name);

    /**
     * Finds a hotel by address, ignoring case.
     *
     * @param address the address to search for
     * @return an optional containing the found hotel, or an empty optional if no hotel is found
     */
    Optional<Hotel> findByAddressIgnoreCase(@Param("address") String address);

    /**
     * Finds hotels by rating.
     *
     * @param rating the rating to match
     * @return a list of hotels with the specified rating
     */
    List<Hotel> findByRating(@Param("rating") double rating);

    // Add other methods as needed for your application
}
