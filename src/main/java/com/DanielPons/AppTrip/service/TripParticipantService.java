package com.DanielPons.AppTrip.service;


import com.DanielPons.AppTrip.model.TripParticipant;

import java.util.List;
import java.util.UUID;

public interface TripParticipantService {
    TripParticipant createTripParticipant(TripParticipant tripParticipant);
    List<TripParticipant> findTripParticipantByTripId(UUID tripId);
}
