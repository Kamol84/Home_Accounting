package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.User;
import pl.kamol84.homeaccounting.repository.UserRepository;

import java.util.List;

//@Controller
//@RequestMapping("/user")
@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{login}")
    public User getUser(@PathVariable String login){
        return userRepository.findUserByLogin(login);
    }

    @PutMapping("/{login}")
    public User updateUser(@PathVariable String login, @RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/{login}")
    public void deleteUser(@PathVariable String login){
        userRepository.delete(userRepository.findUserByLogin(login));
    }
}
