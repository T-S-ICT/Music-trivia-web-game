package sem6.IndividualProject.MusicTrivia.persistence;

import sem6.IndividualProject.MusicTrivia.persistence.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {
    boolean existsById(long id);

    List<UsersEntity> findAll();

    Optional<UsersEntity> findById(long id);

    UsersEntity save(UsersEntity usersEntity);

    void deleteById(long id);


}
