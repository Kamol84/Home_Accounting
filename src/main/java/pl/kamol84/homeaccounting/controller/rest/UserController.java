package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.User;
import pl.kamol84.homeaccounting.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}