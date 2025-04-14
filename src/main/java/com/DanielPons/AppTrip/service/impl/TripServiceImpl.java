package com.DanielPons.AppTrip.service.impl;

import com.DanielPons.AppTrip.model.Trip;
import com.DanielPons.AppTrip.model.TripParticipant;
import com.DanielPons.AppTrip.model.User;
import com.DanielPons.AppTrip.repository.TripParticipantRepository;
import com.DanielPons.AppTrip.repository.TripRepository;
import com.DanielPons.AppTrip.repository.UserRepository;
import com.DanielPons.AppTrip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public Trip createTrip(Trip trip, UUID userId) {
        return tripRepository.save(trip) ;
    }


    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Optional<Trip> getTripById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Trip> getTripById(Long id) {
        return Optional.empty();
    }


}
