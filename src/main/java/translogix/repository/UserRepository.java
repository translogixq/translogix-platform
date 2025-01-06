package translogix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import translogix.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}