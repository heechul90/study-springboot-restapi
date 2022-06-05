package studyspringboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyspringboot.restapi.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
