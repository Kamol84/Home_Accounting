package pl.kamol84.homeaccounting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamol84.homeaccounting.entity.Expense;
import pl.kamol84.homeaccounting.entity.Income;
import pl.kamol84.homeaccounting.entity.User;
import pl.kamol84.homeaccounting.exceptions.NotFoundException;
import pl.kamol84.homeaccounting.repository.ExpenseRepository;
import pl.kamol84.homeaccounting.repository.IncomeRepository;
import pl.kamol84.homeaccounting.repository.UserRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class UserReportService {

    private final UserRepository userRepository;
    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;

    @Autowired
    public UserReportService(UserRepository userRepository, ExpenseRepository expenseRepository, IncomeRepository incomeRepository) {
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
    }

    public List<Income> userIncomeFromYearMonth(Long id, Integer year, Integer month) {
        return incomeRepository.userIncomeFromYearMonth(id, year, month);
    }

    public List<Expense> userExpenseFromYearMonth(Long id, Integer year, Integer month){
        return expenseRepository.userExpenseFromYearMonth(id, year, month);
    }

    public BigDecimal sumUserExpenseFromMonth(Long id, Integer year, Integer month){
        return expenseRepository.sumUserExpenseFromMonth(id, year, month);
    }

    public BigDecimal sumUserIncomeFromMonth(Long id, Integer year, Integer month){
             return incomeRepository.sumUserIncomeFromMonth(id, year, month);
    }

    private User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException("Nie znaleziono użytkownika");
        }
        return user.get();
    }
}
