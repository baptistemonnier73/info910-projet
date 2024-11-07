package org.usmb.bmonnier.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity(name = "appointment")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    private UserEntity user;

    @Column(name = "begin_moment")
    private Instant beginMoment;

    @Column(name = "end_moment")
    private Instant endMoment;

    @PrePersist
    @PreUpdate
    public void validateDates() {
        if (beginMoment != null && endMoment != null && !beginMoment.isBefore(endMoment)) {
            throw new IllegalArgumentException("beginMoment must be before endMoment");
        }
    }
}
