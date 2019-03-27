package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.controller.service.UserService;
import pl.kamol84.homeaccounting.entity.User;

import java.util.List;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.add(user);
//        if (result.hasErrors()) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//        user.setActive(true);
//        userRepository.save(user);
//        return new ResponseEntity(user, new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
//        Optional<User> user = userRepository.findById(id);
//        if (!user.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        return new ResponseEntity<>(user.orElse(null), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
//        if (result.hasErrors()) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//        userRepository.save(user);
//        return new ResponseEntity(user, new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
//        if (!userRepository.findById(id).isPresent()) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//        userRepository.deleteSoft(id);
//        return new ResponseEntity(userRepository.findById(id), new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT);
    }
}