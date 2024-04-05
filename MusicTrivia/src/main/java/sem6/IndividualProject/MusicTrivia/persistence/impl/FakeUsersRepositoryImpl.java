package sem6.IndividualProject.MusicTrivia.persistence.impl;

import org.springframework.stereotype.Repository;
import sem6.IndividualProject.MusicTrivia.persistence.UsersRepository;
import sem6.IndividualProject.MusicTrivia.persistence.entity.UsersEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class FakeUsersRepositoryImpl implements UsersRepository {
    private static long NEXT_ID = 1;

    private final List<UsersEntity> savedUsersEntities;

    public FakeUsersRepositoryImpl(){this.savedUsersEntities = new ArrayList<>();}


    @Override
    public boolean existsById(long id) {
        return this.savedUsersEntities
                .stream()
                .anyMatch(usersEntity -> usersEntity.getId() == id);
    }

    public List<UsersEntity> findAll() {
        return Collections.unmodifiableList(savedUsersEntities);
    }

    @Override
    public Optional<UsersEntity> findById(long id) {
        return this.savedUsersEntities
                .stream()
                .filter(usersEntity -> usersEntity.getId().equals(id))
                .findFirst();
    }

    @Override
    public UsersEntity save(UsersEntity users) {
        if(users.getId() == null){
            users.setId(NEXT_ID);
            NEXT_ID++;
            this.savedUsersEntities.add(users);
        }
        return users;
    }

    @Override
    public void deleteById(long id) {
        this.savedUsersEntities.removeIf(usersEntity -> usersEntity.getId().equals(id));
    }
}
