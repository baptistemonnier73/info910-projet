package org.usmb.bmonnier.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "user")
public class UserEntity {

    @Id
    @Column(name = "user_name", unique = true)
    private String userName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppointmentEntity> appointments;
}
