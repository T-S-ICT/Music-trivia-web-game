package sem6.individualproject.users.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {
    private Long id;
    private String oldPassword;
    private String newPassword;
    private String repeatNewPassword;
}