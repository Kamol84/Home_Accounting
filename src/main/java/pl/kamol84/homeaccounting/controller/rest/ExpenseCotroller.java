package pl.kamol84.homeaccounting.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kamol84.homeaccounting.entity.Expense;
import pl.kamol84.homeaccounting.service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping(path = "/expense", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExpenseCotroller {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseCotroller(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @GetMapping
    public List<Expense> getAllExpense() {
        return expenseService.getExpenses();
    }

    @GetMapping("/{id}")
    public Expense getIncome(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }


    @PutMapping
    public Expense updateExpense(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.delete(id);
    }


}
