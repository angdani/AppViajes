package com.DanielPons.AppTrip.controller;


import com.DanielPons.AppTrip.model.Trip;
import com.DanielPons.AppTrip.model.TripParticipant;
import com.DanielPons.AppTrip.model.User;
import com.DanielPons.AppTrip.repository.TripParticipantRepository;
import com.DanielPons.AppTrip.repository.UserRepository;
import com.DanielPons.AppTrip.service.TripParticipantService;
import com.DanielPons.AppTrip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Declara el controlador que maneja las solicitudes HTTP relacionadas con los viajes
@RestController
@RequestMapping("/api/trips") // Define la ruta base para todas las solicitudes de este controlador, en este caso "/api/trips"
public class TripController {

    private final TripService tripService;
    private final UserRepository userRepository;
    private final TripParticipantRepository tripParticipantRepository;

    // Inyecta la instancia del servicio TripService utilizando la anotación @Autowired
    @Autowired
    public TripController(TripService tripService,  UserRepository userRepository, TripParticipantRepository tripParticipantRepository) {
        this.tripService = tripService;
        this.userRepository = userRepository;
        this.tripParticipantRepository = tripParticipantRepository;
    }

    // Método para crear un nuevo viaje
    // Se asocia con la solicitud POST en la ruta "/api/trips"
    @PostMapping
    public ResponseEntity<?> createTrip(@RequestBody Trip trip, @RequestParam UUID userId) {
        try {
            // 1. Verificar si el usuario existe
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "User not found with id: " + userId));

            // 2. Crear el viaje
            Trip createdTrip = tripService.createTrip(trip, userId);

            // 3. Crear y guardar el participante (creator)
            TripParticipant participant = new TripParticipant();
            participant.setIdTrip(createdTrip); // Usar el viaje creado, no el del request
            participant.setIdUser(user);
            participant.setRole("owner");
            participant.setInvitationStatus("accepted");
            participant.setJoinedAt(OffsetDateTime.now());

            // Guardar el participante (necesitarás inyectar tripParticipantRepository)
            tripParticipantRepository.save(participant);

            // 4. Devolver respuesta
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTrip);
        } catch (ResponseStatusException e) {
            throw e; // Re-lanzar excepciones de estado HTTP
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error creating trip: " + e.getMessage());
        }
    }

    // Método para obtener todos los viajes
    // Se asocia con la solicitud GET en la ruta "/api/trips"
    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips() {
        // Llama al servicio para obtener la lista de viajes
        List<Trip> trips = tripService.getAllTrips();
        // Devuelve la lista de viajes en el cuerpo de la respuesta con un estado HTTP 200 OK
        return ResponseEntity.ok(trips);
    }

    // Método para obtener un viaje por su ID
    // Se asocia con la solicitud GET en la ruta "/api/trips/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable UUID id) {
        // Llama al servicio para obtener un viaje por su ID
        Optional<Trip> trip = tripService.getTripById(id);

        // Si el viaje existe, devuelve una respuesta con el viaje y estado HTTP 200 OK
        // Si el viaje no existe, devuelve una respuesta con estado HTTP 404 Not Found
        return trip.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
