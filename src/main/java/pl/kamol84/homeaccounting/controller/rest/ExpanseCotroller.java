package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        expenseRepository.save(expense);
        return new ResponseEntity(expense, new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }


    @PutMapping
    public ResponseEntity<Expense> updateExpanse(@RequestBody Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        expenseRepository.save(expense);
        return new ResponseEntity(expense, new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Expense> deleteExpanse(@PathVariable Long id) {
        if (!expenseRepository.findById(id).isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        expenseRepository.deleteById(id);
        return new ResponseEntity(expenseRepository.findById(id), new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT);
    }


}
