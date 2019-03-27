package pl.kamol84.homeaccounting.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kamol84.homeaccounting.entity.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByLogin(String login);
    List<User> findAllByActiveIsTrue();

    @Transactional
    @Modifying
    @Query("update User u set u.active =false where u.id =:id")
    int deleteSoft(@Param("id") Long id);
}
