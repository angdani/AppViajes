package com.DanielPons.AppTrip.service.impl;

import com.DanielPons.AppTrip.model.User;
import com.DanielPons.AppTrip.repository.UserRepository;
import com.DanielPons.AppTrip.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return Optional.empty();
    }
}