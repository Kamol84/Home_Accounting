package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.Group;
import pl.kamol84.homeaccounting.service.GroupService;

import java.util.List;

@RestController
@RequestMapping(path = "/group", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping
    public Group createGroup(@RequestBody Group group) {
        return groupService.save(group);
    }

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @PutMapping
    public Group updateGroup(@RequestBody Group group) {
        return groupService.save(group);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        groupService.delete(id);

    }
}
