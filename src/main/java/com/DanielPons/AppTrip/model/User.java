package com.DanielPons.AppTrip.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.time.OffsetDateTime;
import java.util.List;
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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_user", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @ColumnDefault("now()")
    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "last_login")
    private OffsetDateTime lastLogin;

    @OneToMany(mappedBy = "idUser", fetch = FetchType.LAZY)
    private List<TripParticipant> tripParticipants;


    // Constructor mejorado
    public User(String email, String name) {
        this.email = email;
        this.name = name;
        this.createdAt = OffsetDateTime.now();
    }
}