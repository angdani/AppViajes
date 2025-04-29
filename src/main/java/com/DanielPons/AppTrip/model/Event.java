package com.DanielPons.AppTrip.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "\"Events\"")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Events_id_gen")
    @SequenceGenerator(name = "Events_id_gen", sequenceName = "Eventos_id_evento_seq", allocationSize = 1)
    @Column(name = "id_event", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_trip", nullable = false)
    private com.DanielPons.AppTrip.model.Trip idTrip;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "date", length = Integer.MAX_VALUE)
    private String date;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "ubication", length = Integer.MAX_VALUE)
    private String ubication;

}