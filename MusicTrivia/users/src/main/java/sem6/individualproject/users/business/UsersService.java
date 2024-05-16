package sem6.individualproject.users.business;

import sem6.individualproject.users.domain.*;

import java.util.Optional;

public interface UsersService {
    CreateUsersResponse createUser(CreateUsersRequest request);
    GetAllUsersResponse getAllUser();
    void deleteUser(long id);
    Optional<Users> getUser(long id);
    void updateUser(UpdateUsersRequest request);
    String updatePassword(UpdatePasswordRequest request);
    CreateLoginResponse login(CreateLoginRequest request);

}
