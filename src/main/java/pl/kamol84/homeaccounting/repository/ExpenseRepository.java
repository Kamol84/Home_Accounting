package pl.kamol84.homeaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kamol84.homeaccounting.entity.Expense;
import pl.kamol84.homeaccounting.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByUser(User user);

    @Query("SELECT expenses from Expense expenses WHERE user_id = :user_id and year(created)= :year and month(created)= :month")
    List<Expense> userExpenseFromYearMonth(@Param("user_id") Long user_id, @Param("year") Integer year, @Param("month") Integer month);

    @Query("SELECT SUM(expenses.value) from Expense expenses WHERE user_id = :user_id and year(created)= :year and month(created)= :month")
    BigDecimal sumUserExpenseFromMonth(@Param("user_id") Long user_id, @Param("year") Integer year, @Param("month") Integer month);
}
