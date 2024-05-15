package sem6.individualproject.users.business;

import sem6.individualproject.users.domain.AccessToken;

public interface AccessTokenEncoder {
    String encode (AccessToken accessToken);
}
