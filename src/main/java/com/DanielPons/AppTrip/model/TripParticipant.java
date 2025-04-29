package com.DanielPons.AppTrip.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "trip_participants")
public class TripParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_participants_id_gen")
    @SequenceGenerator(name = "trip_participants_id_gen", sequenceName = "trip_participants_id_participant_seq", allocationSize = 1)
    @Column(name = "id_participant", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_trip", nullable = false)
    private Trip idTrip;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_user", nullable = false)
    private com.DanielPons.AppTrip.model.User idUser;

    @ColumnDefault("'participant'")
    @Column(name = "role", length = 50)
    private String role;

    @ColumnDefault("now()")
    @Column(name = "joined_at")
    private OffsetDateTime joinedAt;

    @ColumnDefault("'accepted'")
    @Column(name = "invitation_status", length = 20)
    private String invitationStatus;

    @ColumnDefault("false")
    @Column(name = "is_dirty")
    private Boolean isDirty;

    @ColumnDefault("now()")
    @Column(name = "last_modified")
    private OffsetDateTime lastModified;

    @Column(name = "server_id")
    private Integer serverId;

}