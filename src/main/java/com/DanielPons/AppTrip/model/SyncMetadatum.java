package com.DanielPons.AppTrip.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @ColumnDefault("nextval('sync_metadata_id_sync_seq')")
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