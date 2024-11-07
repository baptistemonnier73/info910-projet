package org.usmb.bmonnier.infrastructure.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Repository;
import org.usmb.bmonnier.domain.UserStorage;
import org.usmb.bmonnier.domain.models.User;
import org.usmb.bmonnier.infrastructure.entities.UserEntity;
import org.usmb.bmonnier.infrastructure.jpa.JpaUserStorage;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserStorageImpl implements UserStorage {

    private final JpaUserStorage jpaUserStorage;

    private final ConversionService conversionService;

    @Override
    public void saveAllUsers(List<User> users) {
        jpaUserStorage.saveAll(users.stream().map(user -> conversionService.convert(user, UserEntity.class)).toList());
    }

    @Override
    public List<User> findAllUsers() {
        return jpaUserStorage.findAll().stream().map(userEntity -> conversionService.convert(userEntity, User.class)).toList();
    }
}
