package sem6.IndividualProject.MusicTrivia.domain.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUsersResponse {
    private List<Users> getAllUser;
}
