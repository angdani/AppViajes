package com.DanielPons.AppTrip.service;

import com.DanielPons.AppTrip.model.Trip;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TripService {

    Trip createTrip(Trip trip, UUID userId);

    List<Trip> getAllTrips();

    Optional<Trip> getTripById(UUID id);

    Optional<Trip> getTripById(Long id);

}
