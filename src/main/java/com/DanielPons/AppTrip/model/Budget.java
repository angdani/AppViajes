package com.DanielPons.AppTrip.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "budgets")
public class Budget {
    @Id
    @ColumnDefault("nextval('budgets_id_budget_seq')")
    @Column(name = "id_budget", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_trip", nullable = false)
    private Trip idTrip;

    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @Column(name = "planned_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal plannedAmount;

    @ColumnDefault("0")
    @Column(name = "actual_amount", precision = 10, scale = 2)
    private BigDecimal actualAmount;

    @ColumnDefault("'USD'")
    @Column(name = "currency", length = 3)
    private String currency;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private com.DanielPons.AppTrip.model.User createdBy;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @ColumnDefault("false")
    @Column(name = "is_dirty")
    private Boolean isDirty;

    @ColumnDefault("now()")
    @Column(name = "last_modified")
    private OffsetDateTime lastModified;

    @Column(name = "server_id")
    private Integer serverId;

}