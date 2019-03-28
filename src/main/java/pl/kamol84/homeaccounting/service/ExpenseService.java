package pl.kamol84.homeaccounting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamol84.homeaccounting.entity.Expense;
import pl.kamol84.homeaccounting.exceptions.BadRequestException;
import pl.kamol84.homeaccounting.exceptions.NotFoundException;
import pl.kamol84.homeaccounting.repository.ExpenseRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    Validator validator;

    public Expense save(Expense expense) {
        Set<ConstraintViolation<Expense>> violations = validator.validate(expense);
        if (!violations.isEmpty()) {
            throw new BadRequestException("wprowadzono niepoprawne dane");
        }
        expenseRepository.save(expense);
        return expense;
    }

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (!expense.isPresent()) {
            throw new NotFoundException("Nie znaleziono wydatku");
        }
        return expense.get();
    }

    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }
}
