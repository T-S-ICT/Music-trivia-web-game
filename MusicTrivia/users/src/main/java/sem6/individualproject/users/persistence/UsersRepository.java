package sem6.individualproject.users.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import sem6.individualproject.users.persistence.entity.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity,Long> {
    boolean existsByEmailOrUsername(String email, String username);
}
