package sem6.IndividualProject.MusicTrivia.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem6.IndividualProject.MusicTrivia.business.UsersService;
import sem6.IndividualProject.MusicTrivia.domain.CreateUsersRequest;
import sem6.IndividualProject.MusicTrivia.domain.CreateUsersResponse;
import sem6.IndividualProject.MusicTrivia.domain.GetUsersResponse;
import sem6.IndividualProject.MusicTrivia.domain.Users;
import sem6.IndividualProject.MusicTrivia.persistence.UsersRepository;
import sem6.IndividualProject.MusicTrivia.persistence.entity.UsersEntity;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public CreateUsersResponse createUsers(CreateUsersRequest request) {
        UsersEntity newUsers = UsersEntity.builder()
                .username(request.getUsername())
                .build();

        UsersEntity savedUsers = usersRepository.save(newUsers);

        return CreateUsersResponse.builder()
                .id(savedUsers.getId())
                .build();
    }

    @Override
    public GetUsersResponse getUsers() {
        List<Users> users = usersRepository.getUsers()
                .stream()
                .map(UsersConverter::convert)
                .toList();

        return GetUsersResponse.builder()
                .getUsers(users)
                .build();
    }
}
