package sem6.IndividualProject.MusicTrivia.business;

import sem6.IndividualProject.MusicTrivia.domain.CreateUsersRequest;
import sem6.IndividualProject.MusicTrivia.domain.CreateUsersResponse;
import sem6.IndividualProject.MusicTrivia.domain.GetUsersResponse;

public interface UsersService {
    CreateUsersResponse createUsers(CreateUsersRequest request);
    GetUsersResponse getUsers();

}
