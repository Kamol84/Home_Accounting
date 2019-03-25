package pl.kamol84.homeaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamol84.homeaccounting.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {


}
