package sem6.IndividualProject.MusicTrivia.business;

import sem6.IndividualProject.MusicTrivia.domain.CreateUsersRequest;
import sem6.IndividualProject.MusicTrivia.domain.CreateUsersResponse;
import sem6.IndividualProject.MusicTrivia.domain.GetAllUsersResponse;

public interface UsersService {
    CreateUsersResponse createUser(CreateUsersRequest request);
    GetAllUsersResponse getUsers();

}
