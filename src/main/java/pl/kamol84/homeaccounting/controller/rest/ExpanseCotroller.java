package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.Expense;
import pl.kamol84.homeaccounting.repository.ExpenseRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/expanse", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExpanseCotroller {

    @Autowired
    ExpenseRepository expenseRepository;

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @GetMapping
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }


    @PutMapping
    public Expense updateExpanse(@RequestBody Expense expense) {
        return expenseRepository.save(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpanse(@PathVariable Long id) {
        expenseRepository.deleteById(id);
    }


}
