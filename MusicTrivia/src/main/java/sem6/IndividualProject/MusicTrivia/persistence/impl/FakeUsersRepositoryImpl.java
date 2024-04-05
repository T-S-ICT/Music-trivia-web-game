package sem6.IndividualProject.MusicTrivia.persistence.impl;

import org.springframework.stereotype.Repository;
import sem6.IndividualProject.MusicTrivia.persistence.UsersRepository;
import sem6.IndividualProject.MusicTrivia.persistence.entity.UsersEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class FakeUsersRepositoryImpl implements UsersRepository {
    private static long NEXT_ID = 1;

    private final List<UsersEntity> savedUsersEntity;

    public FakeUsersRepositoryImpl(){this.savedUsersEntity = new ArrayList<>();}


    @Override
    public boolean existsById(long id) {
        return this.savedUsersEntity
                .stream()
                .anyMatch(usersEntity -> usersEntity.getId() == id);
    }

    @Override
    public List<UsersEntity> getUsers() {
        return Collections.unmodifiableList(savedUsersEntity);
    }

    @Override
    public UsersEntity save(UsersEntity users) {
        if(users.getId() == null){
            users.setId(NEXT_ID);
            NEXT_ID++;
            this.savedUsersEntity.add(users);
        }
        return users;
    }
}
