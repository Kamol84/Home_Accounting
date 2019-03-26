package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.User;
import pl.kamol84.homeaccounting.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public User addUser(@RequestBody User user) {
        user.setActive(true);
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new Exception (id + " - user not found");
        }
        return new ResponseEntity<>(user.orElse(null), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteSoft(id);
    }
}