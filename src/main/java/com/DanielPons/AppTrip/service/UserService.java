package com.DanielPons.AppTrip.service;

import com.DanielPons.AppTrip.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(UUID id);
}

