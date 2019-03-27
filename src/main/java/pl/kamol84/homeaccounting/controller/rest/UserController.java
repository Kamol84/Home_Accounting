package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.User;
import pl.kamol84.homeaccounting.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody @Valid User user, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        user.setActive(true);
        userRepository.save(user);
        return new ResponseEntity(user, new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAllByActiveIsTrue();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(user.orElse(null), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody @Valid User user, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        userRepository.save(user);
        return new ResponseEntity(user, new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        if (!userRepository.findById(id).isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
       userRepository.deleteSoft(id);
        return new ResponseEntity(userRepository.findById(id), new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT);
    }
}