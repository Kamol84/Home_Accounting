package pl.kamol84.homeaccounting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamol84.homeaccounting.entity.User;
import pl.kamol84.homeaccounting.exceptions.BadRequestException;
import pl.kamol84.homeaccounting.exceptions.NotFoundException;
import pl.kamol84.homeaccounting.repository.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Validator validator;

    public User save(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            throw new BadRequestException("wprowadzono niepoprawne dane");
        }
        userRepository.save(user);
        return user;
    }

    public List<User> getUsers(){
        return userRepository.findAllByActiveIsTrue();
    }

    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
        {
            throw new NotFoundException("Nie znaleziono użytkownika");
        }
        return user.get();
    }

    public void delete(Long id){
        userRepository.deleteSoft(id);
    }
}
