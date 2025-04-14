package com.DanielPons.AppTrip.repository;

import com.DanielPons.AppTrip.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TripRepository extends JpaRepository<Trip, Long> {


}