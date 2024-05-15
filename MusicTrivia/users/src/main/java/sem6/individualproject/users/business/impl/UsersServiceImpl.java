package sem6.individualproject.users.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sem6.individualproject.users.business.UsersService;
import sem6.individualproject.users.business.exception.EmailExistException;
import sem6.individualproject.users.business.exception.InvalidUsersException;
import sem6.individualproject.users.business.exception.PasswordException;
import sem6.individualproject.users.business.exception.UserExistException;
import sem6.individualproject.users.domain.*;
import sem6.individualproject.users.persistence.UsersRepository;
import sem6.individualproject.users.persistence.entity.RoleEnum;
import sem6.individualproject.users.persistence.entity.UserRoleEntity;
import sem6.individualproject.users.persistence.entity.UsersEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CreateUsersResponse createUser(CreateUsersRequest request) {
        if (usersRepository.existsByEmailOrUsername(request.getEmail(), request.getUsername())){
            throw new UserExistException();
        }

        String encodePassword = passwordEncoder.encode(request.getPassword());

        UsersEntity newUsers = UsersEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                //.password(request.getPassword())
                .password(encodePassword)
                .build();

        newUsers.setUserRoles(Set.of(UserRoleEntity.builder()
                .users(newUsers)
                .role(RoleEnum.USER)
                .build()));

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

        if (usersRepository.existsByEmail(request.getEmail())){
            throw new EmailExistException();
        }

        UsersEntity usersEntity = usersEntityOptional.get();
        usersEntity.setEmail(request.getEmail());

        usersRepository.save(usersEntity);
    }

    @Override
    public String updatePassword(UpdatePasswordRequest request) {
        //need to add a password encoder
        Optional<UsersEntity> usersEntityOptional = usersRepository.findById(request.getId());
        if(usersEntityOptional.isEmpty()){
            throw new InvalidUsersException("USER_ID_INVALID");
        }

        if (!usersRepository.existsByIdAndPassword(request.getId(),request.getOldPassword())){
            throw new PasswordException("Password is incorrect.");
        }

        if(!request.getNewPassword().equals(request.getRepeatNewPassword())){
            throw new PasswordException("Password is not the same.");
        }

        UsersEntity usersEntity = usersEntityOptional.get();
        usersEntity.setPassword(request.getNewPassword());

        usersRepository.save(usersEntity);
        return "Password successfully changed.";
    }
}
