package org.usmb.bmonnier.domain;

import org.usmb.bmonnier.domain.models.User;

import java.util.List;

public interface UserStorage {
    void saveAllUsers(List<User> users);

    List<User> findAllUsers();
}
