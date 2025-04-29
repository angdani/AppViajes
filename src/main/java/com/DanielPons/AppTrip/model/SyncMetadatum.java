package com.DanielPons.AppTrip.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "sync_metadata")
public class SyncMetadatum {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sync_metadata_id_gen")
    @SequenceGenerator(name = "sync_metadata_id_gen", sequenceName = "sync_metadata_id_sync_seq", allocationSize = 1)
    @Column(name = "id_sync", nullable = false)
    private Integer id;

    @Column(name = "table_name", nullable = false, length = 50)
    private String tableName;

    @Column(name = "last_sync_at")
    private OffsetDateTime lastSyncAt;

    @Column(name = "last_sync_status", length = 20)
    private String lastSyncStatus;

    @ColumnDefault("0")
    @Column(name = "pending_changes")
    private Integer pendingChanges;

}