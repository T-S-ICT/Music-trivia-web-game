package sem6.IndividualProject.MusicTrivia.persistence;

import sem6.IndividualProject.MusicTrivia.domain.Users;
import sem6.IndividualProject.MusicTrivia.persistence.entity.UsersEntity;

import java.util.List;

public interface UsersRepository {
    boolean existsById(long id);

    List<UsersEntity> getUsers();

    UsersEntity save(UsersEntity users);


}
