package org.usmb.bmonnier.domain.models;

import lombok.Data;

import java.time.Instant;

@Data
public class Appointment {
    private Instant beginMoment;
    private Instant endMoment;
}
