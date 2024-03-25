package com.example.hotelbackend.model.dao;

import com.example.hotelbackend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {
}
