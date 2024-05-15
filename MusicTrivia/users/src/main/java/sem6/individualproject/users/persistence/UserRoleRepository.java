package sem6.individualproject.users.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import sem6.individualproject.users.persistence.entity.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
}
