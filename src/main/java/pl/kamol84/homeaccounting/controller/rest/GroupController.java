package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.Group;
import pl.kamol84.homeaccounting.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @PostMapping
    public Group group(@RequestBody Group group) {
        return groupRepository.save(group);
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/{name}")
    public Group getGroup(@PathVariable String name) {
        return groupRepository.findGroupByName(name);
    }

    @PutMapping
    public Group updateGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupRepository.deleteById(id);
    }

}
