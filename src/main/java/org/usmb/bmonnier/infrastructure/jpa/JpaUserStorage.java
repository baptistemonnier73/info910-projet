package org.usmb.bmonnier.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.usmb.bmonnier.infrastructure.entities.UserEntity;

@Repository
public interface JpaUserStorage extends JpaRepository<UserEntity, String> {
}
