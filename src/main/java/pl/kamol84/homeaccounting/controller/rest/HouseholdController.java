package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.Household;
import pl.kamol84.homeaccounting.service.HouseholdService;

import java.util.List;

@RestController
@RequestMapping(path = "/household", produces = MediaType.APPLICATION_JSON_VALUE)
public class HouseholdController {

    private final HouseholdService householdService;

    @Autowired
    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping
    public Household createHousehold(@RequestBody Household household) {
        return householdService.save(household);
    }

    @GetMapping
    public List<Household> getAllHousehold() {
        return householdService.getHousehold();
    }

    @GetMapping("/{id}")
    public Household getHousehold(@PathVariable Long id) {
        return householdService.getHouseholdById(id);
    }

    @PutMapping
    public Household updateHousehold(@RequestBody Household household) {
        return householdService.save(household);
    }

    @DeleteMapping("/{id}")
    public void deleteHousehold(@PathVariable Long id) {
        householdService.delete(id);
    }
}
