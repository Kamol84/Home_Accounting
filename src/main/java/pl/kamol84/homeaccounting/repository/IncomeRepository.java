package pl.kamol84.homeaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamol84.homeaccounting.entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {


}
