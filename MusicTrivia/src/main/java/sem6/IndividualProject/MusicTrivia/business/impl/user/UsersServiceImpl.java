package sem6.IndividualProject.MusicTrivia.business.impl.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem6.IndividualProject.MusicTrivia.business.UsersService;
import sem6.IndividualProject.MusicTrivia.domain.users.*;
import sem6.IndividualProject.MusicTrivia.persistence.UsersRepository;
import sem6.IndividualProject.MusicTrivia.persistence.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public CreateUsersResponse createUser(CreateUsersRequest request) {
        UsersEntity newUsers = UsersEntity.builder()
                .username(request.getUsername())
                .build();

        UsersEntity savedUsers = usersRepository.save(newUsers);

        return CreateUsersResponse.builder()
                .id(savedUsers.getId())
                .build();
    }

    @Override
    public GetAllUsersResponse getAllUser() {
        List<Users> users = usersRepository.findAll()
                .stream()
                .map(UsersConverter::convert)
                .toList();

        return GetAllUsersResponse.builder()
                .getAllUser(users)
                .build();
    }

    @Override
    public void deleteUser(long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Optional<Users> getUser(long id) {
        return usersRepository.findById(id).map(UsersConverter::convert);
    }

    @Override
    public void updateUser(UpdateUsersRequest request) {
        //Not implement yet
    }
}
