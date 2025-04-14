package com.DanielPons.AppTrip.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @ColumnDefault("nextval('tasks_id_task_seq')")
    @Column(name = "id_task", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_trip", nullable = false)
    private Trip idTrip;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ColumnDefault("false")
    @Column(name = "is_completed")
    private Boolean isCompleted;

    @ColumnDefault("2")
    @Column(name = "priority")
    private Integer priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to")
    private com.DanielPons.AppTrip.model.User assignedTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private com.DanielPons.AppTrip.model.User createdBy;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "completed_at")
    private OffsetDateTime completedAt;

    @ColumnDefault("false")
    @Column(name = "is_dirty")
    private Boolean isDirty;

    @ColumnDefault("now()")
    @Column(name = "last_modified")
    private OffsetDateTime lastModified;

    @Column(name = "server_id")
    private Integer serverId;

}