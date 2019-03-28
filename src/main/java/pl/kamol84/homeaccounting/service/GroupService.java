package pl.kamol84.homeaccounting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamol84.homeaccounting.entity.Group;
import pl.kamol84.homeaccounting.exceptions.BadRequestException;
import pl.kamol84.homeaccounting.exceptions.NotFoundException;
import pl.kamol84.homeaccounting.repository.GroupRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    Validator validator;

    public Group save(Group group) {
        Set<ConstraintViolation<Group>> violations = validator.validate(group);
        if (!violations.isEmpty()) {
            throw new BadRequestException("wprowadzono niepoprawne dane");
        }

        return group;
    }

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Long id) {
        Optional<Group> group = groupRepository.findById(id);
        if(!group.isPresent()){
            throw new NotFoundException("Nie znaleziono grupy");
        }
        return group.get();
    }

    public void delete(Long id){
        groupRepository.deleteById(id);
    }

}
