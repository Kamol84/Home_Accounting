package pl.kamol84.homeaccounting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamol84.homeaccounting.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
