package sem6.IndividualProject.MusicTrivia.business;

import sem6.IndividualProject.MusicTrivia.domain.users.*;

import java.util.Optional;

public interface UsersService {
    CreateUsersResponse createUser(CreateUsersRequest request);
    GetAllUsersResponse getAllUser();
    void deleteUser(long id);
    Optional<Users> getUser(long id);
    void updateUser(UpdateUsersRequest request);

}
