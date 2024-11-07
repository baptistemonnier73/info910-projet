package org.usmb.bmonnier.domain.models;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String userName;

    private List<Appointment> appointments;
}
