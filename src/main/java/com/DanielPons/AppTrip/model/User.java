package com.DanielPons.AppTrip.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id_user", nullable = false)
    private UUID id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    @OneToMany(mappedBy = "createdBy")
    private Set<Budget> budgets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "uploadedBy")
    private Set<Document> documents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "createdBy")
    private Set<Expens> expenses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "createdBy")
    private Set<Note> notes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "addedBy")
    private Set<PointsOfInterest> pointsOfInterests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "assignedTo")
    private Set<Task> tasksAssigned = new LinkedHashSet<>();

    @OneToMany(mappedBy = "createdBy")
    private Set<Task> tasksCreator = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUser")
    private Set<TripParticipant> tripParticipants = new LinkedHashSet<>();

}