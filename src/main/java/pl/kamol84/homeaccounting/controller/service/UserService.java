package pl.kamol84.homeaccounting.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamol84.homeaccounting.entity.User;
import pl.kamol84.homeaccounting.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void add(User user){
        user.setActive(true);
        userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAllByActiveIsTrue();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public  void delete(Long id){
        userRepository.deleteSoft(id);
    }
}
