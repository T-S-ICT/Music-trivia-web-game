package sem6.individualproject.users.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUsersRequest {
    private Long id;
    private String username;
    private String email;
    private String password;
}
