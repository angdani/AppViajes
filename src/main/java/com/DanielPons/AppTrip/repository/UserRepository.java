package com.DanielPons.AppTrip.repository;

import com.DanielPons.AppTrip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}