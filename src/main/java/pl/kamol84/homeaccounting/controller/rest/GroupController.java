package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.Group;
import pl.kamol84.homeaccounting.repository.GroupRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody @Valid Group group, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        groupRepository.save(group);
        return new ResponseEntity(group, new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable Long id) {
        Optional<Group> group = groupRepository.findById(id);
        if (!group.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(group.orElse(null), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Group> updateGroup(@RequestBody @Valid Group group, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }
        groupRepository.save(group);
        return new ResponseEntity(group, new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable Long id) {
        if (!groupRepository.findById(id).isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        groupRepository.deleteById(id);
        return new ResponseEntity(groupRepository.findById(id), new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT);
    }
}
