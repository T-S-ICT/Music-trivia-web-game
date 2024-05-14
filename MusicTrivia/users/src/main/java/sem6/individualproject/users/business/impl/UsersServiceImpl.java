package sem6.individualproject.users.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sem6.individualproject.users.business.UsersService;
import sem6.individualproject.users.business.exception.InvalidUsersException;
import sem6.individualproject.users.business.exception.UserExistException;
import sem6.individualproject.users.domain.*;
import sem6.individualproject.users.persistence.UsersRepository;
import sem6.individualproject.users.persistence.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    @Override
    public CreateUsersResponse createUser(CreateUsersRequest request) {
        if (usersRepository.existsByEmailOrUsername(request.getEmail(), request.getUsername())){
            throw new UserExistException();
        }

        UsersEntity newUsers = UsersEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
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
        Optional<UsersEntity> usersEntityOptional = usersRepository.findById(request.getId());
        if(usersEntityOptional.isEmpty()){
            throw new InvalidUsersException("USER_ID_INVALID");
        }

        UsersEntity usersEntity = usersEntityOptional.get();
        usersEntity.setEmail(request.getEmail());

        usersRepository.save(usersEntity);
    }
}
