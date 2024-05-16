package sem6.individualproject.users.business.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sem6.individualproject.users.business.AccessTokenEncoder;
import sem6.individualproject.users.business.UsersService;
import sem6.individualproject.users.business.exception.*;
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
    private final AccessTokenEncoder encoder;
    private final AccessToken accessToken;

    @Override
    @Transactional
    public CreateUsersResponse createUser(CreateUsersRequest request) {
        if (usersRepository.existsByEmailOrUsername(request.getEmail(), request.getUsername())){
            throw new UserExistException();
        }

        String encodePassword = passwordEncoder.encode(request.getPassword());

        UsersEntity newUsers = UsersEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(encodePassword)
                .build();

        newUsers.setUserRoles(Set.of(UserRoleEntity.builder()
                .users(newUsers)
                .role(RoleEnum.USER)
                .build()));

        UsersEntity savedUsers = usersRepository.save(newUsers);

        List<String> roles = savedUsers.getUserRoles().stream()
                .map(userRoles -> userRoles.getRole().toString())
                .toList();

        //Look for another way to fix encode
        String token = encoder.encode(
                AccessToken.builder()
                        .subject(savedUsers.getUsername())
                        .roles(roles)
                        .userId(savedUsers.getId())
                        .build());

        return CreateUsersResponse.builder()
                .accessToken(token)
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
        accessTokenPermission(id);
        return usersRepository.findById(id).map(UsersConverter::convert);
    }

    @Override
    public void updateUser(UpdateUsersRequest request) {
        accessTokenPermission(request.getId());

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
        accessTokenPermission(request.getId());

        Optional<UsersEntity> usersEntityOptional = usersRepository.findById(request.getId());
        if(usersEntityOptional.isEmpty()){
            throw new InvalidUsersException("USER_ID_INVALID");
        }

        if (!passwordEncoder.matches(request.getOldPassword(),usersEntityOptional.get().getPassword())){
            throw new PasswordException("Password is incorrect.");
        }

        if(!request.getNewPassword().equals(request.getRepeatNewPassword())){
            throw new PasswordException("Password is not the same.");
        }

        UsersEntity usersEntity = usersEntityOptional.get();
        String encodePassword = passwordEncoder.encode(request.getNewPassword());
        usersEntity.setPassword(encodePassword);

        usersRepository.save(usersEntity);
        return "Password successfully changed.";
    }

    @Override
    public CreateLoginResponse login(CreateLoginRequest request) {
        UsersEntity users = usersRepository.findByEmail(request.getEmail());
        if(users == null){
            throw new InvalidCredentialsException();
        }

        if (!passwordEncoder.matches(request.getPassword(),users.getPassword())){
            throw new InvalidCredentialsException();
        }

        List<String> roles = users.getUserRoles().stream()
                .map(userRole -> userRole.getRole().toString())
                .toList();

        String accessToken = encoder.encode(
                AccessToken.builder()
                        .subject(users.getUsername())
                        .roles(roles)
                        .userId(users.getId())
                        .build());

        return CreateLoginResponse.builder()
                .accessToken(accessToken)
                .build();
    }

    private void accessTokenPermission(long id){
        //change accesstoken id to username.
        if (!accessToken.hasRole(RoleEnum.ADMIN.name())){
            if (!accessToken.getUserId().equals(id)){
                throw new UnauthorizedDataAccessException("USER_ID_NOT_FROM_LOGGED_IN_USER");
            }
        }
    }
}
