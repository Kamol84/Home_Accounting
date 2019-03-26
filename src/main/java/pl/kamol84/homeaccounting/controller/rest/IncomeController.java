package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.Income;
import pl.kamol84.homeaccounting.repository.IncomeRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/income", produces = MediaType.APPLICATION_JSON_VALUE)
public class IncomeController {

    @Autowired
    IncomeRepository incomeRepository;

    @PostMapping
    public Income addIncome(@RequestBody Income income) {
        return incomeRepository.save(income);
    }

    @GetMapping
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }


    @PutMapping
    public Income updateIncome(@RequestBody Income income) {
        return incomeRepository.save(income);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeRepository.deleteById(id);
    }
}
