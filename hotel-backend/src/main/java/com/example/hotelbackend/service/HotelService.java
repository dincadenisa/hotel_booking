package com.example.hotelbackend.service;

import com.example.hotelbackend.api.model.HotelRegistrationBody;
import com.example.hotelbackend.exception.HotelAlreadyExistsException;
import com.example.hotelbackend.model.Hotel;
import com.example.hotelbackend.model.dao.HotelDAO;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service managing operations related to hotels.
 */
@Service
public class HotelService {

    private final HotelDAO hotelDAO;

    public HotelService(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    /**
     * Registers a new hotel using the provided registration body.
     * @param registrationBody The registration details for the new hotel.
     * @return The registered hotel.
     * @throws HotelAlreadyExistsException if the hotel already exists.
     */
    public Hotel registerHotel(HotelRegistrationBody registrationBody) throws HotelAlreadyExistsException {
        Optional<Hotel> existingHotel = hotelDAO.findByNameIgnoreCase(registrationBody.getName());
        if (existingHotel.isPresent()) {
            throw new HotelAlreadyExistsException();
        }
        Hotel hotel = new Hotel();
        hotel.setName(registrationBody.getName());
        hotel.setAddress(registrationBody.getAddress());
        hotel.setDescription(registrationBody.getDescription());
        hotel.setRating(registrationBody.getRating());
        hotel.setRoomsCount(registrationBody.getRoomsCount());
        hotel.setFacilities(registrationBody.getFacilities());
        return hotelDAO.save(hotel);
    }

    /**
     * Deletes a hotel by its ID.
     * @param id The ID of the hotel to delete.
     */
    public void deleteHotel(Long id) {
        hotelDAO.deleteById(id);
    }

    /**
     * Retrieves a hotel by its ID.
     * @param id The ID of the hotel.
     * @return The retrieved hotel.
     */
    public Optional<Hotel> getHotelById(Long id) {
        return hotelDAO.findById(id);
    }

    /**
     * Updates a hotel's details based on the provided registration body and ID.
     * @param id The ID of the hotel to update.
     * @param registrationBody The details to update.
     * @return The updated hotel.
     */
    public Optional<Hotel> updateHotel(Long id, HotelRegistrationBody registrationBody) {
        Optional<Hotel> existingHotel = hotelDAO.findById(id);
        if (existingHotel.isPresent()) {
            Hotel hotel = existingHotel.get();
            hotel.setName(registrationBody.getName());
            hotel.setAddress(registrationBody.getAddress());
            hotel.setDescription(registrationBody.getDescription());
            hotel.setRating(registrationBody.getRating());
            hotel.setRoomsCount(registrationBody.getRoomsCount());
            hotel.setFacilities(registrationBody.getFacilities());
            hotelDAO.save(hotel);
            return Optional.of(hotel);
        }
        return Optional.empty();
    }
}
