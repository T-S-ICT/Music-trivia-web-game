package sem6.individualproject.users.business;

import sem6.individualproject.users.domain.AccessToken;

public interface AccessTokenDecoder {
    AccessToken decode(String accessTokenEncoded);
}
