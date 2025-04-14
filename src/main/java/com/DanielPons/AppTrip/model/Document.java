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
@Table(name = "documents")
public class Document {
    @Id
    @ColumnDefault("nextval('documents_id_document_seq')")
    @Column(name = "id_document", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_trip", nullable = false)
    private Trip idTrip;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "file_url", nullable = false)
    private String fileUrl;

    @Column(name = "file_type", length = 50)
    private String fileType;

    @ColumnDefault("now()")
    @Column(name = "upload_date")
    private OffsetDateTime uploadDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploaded_by")
    private com.DanielPons.AppTrip.model.User uploadedBy;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ColumnDefault("false")
    @Column(name = "is_dirty")
    private Boolean isDirty;

    @ColumnDefault("now()")
    @Column(name = "last_modified")
    private OffsetDateTime lastModified;

    @Column(name = "server_id")
    private Integer serverId;

}