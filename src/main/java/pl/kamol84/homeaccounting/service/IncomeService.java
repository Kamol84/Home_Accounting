package pl.kamol84.homeaccounting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamol84.homeaccounting.entity.Income;
import pl.kamol84.homeaccounting.exceptions.BadRequestException;
import pl.kamol84.homeaccounting.exceptions.NotFoundException;
import pl.kamol84.homeaccounting.repository.IncomeRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IncomeService {

    private final IncomeRepository incomeRepository;
    private final Validator validator;

    @Autowired
    public IncomeService(IncomeRepository incomeRepository, Validator validator) {
        this.incomeRepository = incomeRepository;
        this.validator = validator;
    }

    public Income save(Income income) {
        Set<ConstraintViolation<Income>> violations = validator.validate(income);
        if (!violations.isEmpty()) {
            throw new BadRequestException("wprowadzono niepoprawne dane");
        }
        incomeRepository.save(income);
        return income;
    }

    public List<Income> getIncomes() {
        return incomeRepository.findAll();
    }

    public Income getIncomeById(Long id) {
        Optional<Income> income = incomeRepository.findById(id);
        if (!income.isPresent()) {
            throw new NotFoundException("Nie znaleziono wpłaty");
        }
        return income.get();
    }

    public void delete(Long id) {
        incomeRepository.deleteById(id);
    }

}
