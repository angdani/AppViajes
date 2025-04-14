package com.DanielPons.AppTrip.service.impl;

import com.DanielPons.AppTrip.model.TripParticipant;
import com.DanielPons.AppTrip.repository.TripParticipantRepository;
import com.DanielPons.AppTrip.repository.TripRepository;
import com.DanielPons.AppTrip.service.TripParticipantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class TripParticipantServiceImpl implements TripParticipantService {

    private final TripParticipantRepository tripParticipantRepository;

    public TripParticipantServiceImpl(TripParticipantRepository tripParticipantRepository) {
        this.tripParticipantRepository = tripParticipantRepository;
    }


    @Override
    public TripParticipant createTripParticipant(TripParticipant tripParticipant) {
        return tripParticipantRepository.save(tripParticipant);
    }

    @Override
    public List<TripParticipant> findTripParticipantByTripId(UUID tripId) {
        return List.of();
    }
}
