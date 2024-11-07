package org.usmb.bmonnier.domain;

import org.usmb.bmonnier.domain.models.User;

import java.util.List;

public interface UserService {
    void saveUsers(List<User> users);

    List<User> getUsers();
}
