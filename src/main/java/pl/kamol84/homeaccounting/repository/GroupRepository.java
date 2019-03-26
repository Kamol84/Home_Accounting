package pl.kamol84.homeaccounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamol84.homeaccounting.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findGroupByName(String name);

}
