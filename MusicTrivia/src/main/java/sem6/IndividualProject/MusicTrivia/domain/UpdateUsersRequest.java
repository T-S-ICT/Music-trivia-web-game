package sem6.IndividualProject.MusicTrivia.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUsersRequest {
    private Long id;
    private String email;
}
