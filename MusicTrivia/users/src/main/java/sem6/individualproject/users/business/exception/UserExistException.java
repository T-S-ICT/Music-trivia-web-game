package sem6.individualproject.users.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserExistException extends ResponseStatusException {
    public UserExistException(){super(HttpStatus.CONFLICT,"User already exist.");}
}
