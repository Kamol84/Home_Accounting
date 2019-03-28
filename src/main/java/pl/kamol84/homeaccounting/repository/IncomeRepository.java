package pl.kamol84.homeaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kamol84.homeaccounting.entity.Expense;
import pl.kamol84.homeaccounting.entity.Income;
import pl.kamol84.homeaccounting.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    List<Income> findAllByUser(User user);

    @Query("SELECT income from Income income WHERE user_id = :user_id and year(created)= :year and month(created)= :month")
    List<Income> userIncomeFromYearMonth(@Param("user_id") Long user_id, @Param("year") Integer year, @Param("month") Integer month);

    @Query("SELECT SUM(income.value) from Income income WHERE user_id = :user_id and year(created)= :year and month(created)= :month")
    BigDecimal sumUserIncomeFromMonth(@Param("user_id") Long user_id, @Param("year") Integer year, @Param("month") Integer month);
}
