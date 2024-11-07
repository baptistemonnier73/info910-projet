package org.usmb.bmonnier.domain.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.usmb.bmonnier.domain.UserService;
import org.usmb.bmonnier.domain.UserStorage;
import org.usmb.bmonnier.domain.models.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStorage userStorage;

    @Override
    public void saveUsers(List<User> users) {
        userStorage.saveAllUsers(users);
    }

    @Override
    public List<User> getUsers() {
        return userStorage.findAllUsers();
    }
}
