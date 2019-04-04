package pl.kamol84.homeaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamol84.homeaccounting.entity.Household;

public interface HouseholdRepository extends JpaRepository<Household, Long> {

    Household findHouseholdByName(String name);

}
