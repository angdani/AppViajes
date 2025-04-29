package com.DanielPons.AppTrip.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Trips\"")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Trips_id_gen")
    @SequenceGenerator(name = "Trips_id_gen", sequenceName = "Viajes_id_seq", allocationSize = 1)
    @Column(name = "id_trip", nullable = false)
    private Long id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "idTrip")
    private Set<Event> events = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTrip")
    private Set<com.DanielPons.AppTrip.model.Budget> budgets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTrip")
    private Set<com.DanielPons.AppTrip.model.Document> documents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTrip")
    private Set<com.DanielPons.AppTrip.model.Expens> expenses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTrip")
    private Set<com.DanielPons.AppTrip.model.Note> notes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTrip")
    private Set<com.DanielPons.AppTrip.model.PointsOfInterest> pointsOfInterests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTrip")
    private Set<com.DanielPons.AppTrip.model.Task> tasks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idTrip")
    private Set<com.DanielPons.AppTrip.model.TripParticipant> tripParticipants = new LinkedHashSet<>();

}