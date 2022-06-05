package studyspringboot.restapi.core.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studyspringboot.restapi.core.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
