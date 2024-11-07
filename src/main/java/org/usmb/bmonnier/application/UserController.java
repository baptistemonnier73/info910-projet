package org.usmb.bmonnier.application;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.usmb.bmonnier.domain.UserService;
import org.usmb.bmonnier.domain.models.User;

import java.util.List;

@RestController(value = "/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(name = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(name = "/users", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> saveUsers(@RequestBody List<User> users, HttpServletResponse response) {
        userService.saveUsers(users);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
