package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.Income;
import pl.kamol84.homeaccounting.service.IncomeService;

import java.util.List;

@RestController
@RequestMapping(path = "/income", produces = MediaType.APPLICATION_JSON_VALUE)
public class IncomeController {

    @Autowired
    IncomeService incomeService;

    @PostMapping
    public Income addIncome(@RequestBody Income income) {
        return incomeService.save(income);
    }

    @GetMapping
    public List<Income> getAllIncome() {
        return incomeService.getIncomes();
    }

    @GetMapping("/{id}")
    public Income getIncome(@PathVariable Long id) {
        return incomeService.getIncomeById(id);
    }

    @PutMapping
    public Income updateIncome(@RequestBody Income income) {
        return incomeService.save(income);
    }

    @DeleteMapping("/{id}")
    public void deleteIncome(@PathVariable Long id) {
        incomeService.delete(id);
    }
}
